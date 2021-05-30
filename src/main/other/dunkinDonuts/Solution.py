import json
from collections.abc import Iterable
from urllib.request import urlopen

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from scipy.spatial import Voronoi, voronoi_plot_2d, distance
from shapely.geometry import Point
from shapely.geometry.multipolygon import MultiPolygon
from shapely.geometry.polygon import Polygon


def flatten(x):
    if isinstance(x, Iterable) and isinstance(x[0], Iterable) and isinstance(x[0][0], Iterable):
        return [a for i in x for a in flatten(i)]
    else:
        return [x]


def closest_dunkin(vertex, dunkins):
    return dunkins[distance.cdist([vertex], dunkins).argmin()]


def haversine_np(p1, p2):
    lon1, lat1, lon2, lat2 = map(np.radians, [p1[0], p1[1], p2[0], p2[1]])

    dlon = lon2 - lon1
    dlat = lat2 - lat1

    a = np.sin(dlat / 2.0) ** 2 + np.cos(lat1) * np.cos(lat2) * np.sin(dlon / 2.0) ** 2

    c = 2 * np.arcsin(np.sqrt(a))
    km = 6367 * c
    return km


def print_closest_dis():
    # Load data
    df = pd.read_csv('https://raw.githubusercontent.com/trendct/dunkin-donuts-ct/master/dunkindonuts.csv')
    ma_dunkin_donuts = df.loc[df['state'] == 'MA']
    dunkin_donuts_coordinates = ma_dunkin_donuts[['lng', 'lat']].to_numpy()

    with urlopen('https://raw.githubusercontent.com/plotly/datasets/master/geojson-counties-fips.json') as response:
        counties = json.load(response)
        df = pd.json_normalize(counties['features'])
        ma_geodata = pd.json_normalize(counties['features'])[df['properties.STATE'] == '25'][
            'geometry.coordinates'].to_numpy()
        ma_coordinates = flatten(ma_geodata)

    # Create Voronoi and Polygons
    vor = Voronoi(dunkin_donuts_coordinates)
    polygons = [Polygon(county) for county in ma_coordinates]
    polygon = MultiPolygon(polygons)

    biggestDistanceYet = 0
    bestVertex = []
    closest_dunkin_coord = []

    # Calculate best vertex
    for vertex in vor.vertices:
        closest_dunkin_branch = closest_dunkin(vertex, dunkin_donuts_coordinates)
        minDis = distance.cdist([vertex], [closest_dunkin_branch])
        if biggestDistanceYet < minDis and polygon.contains(Point(vertex)):
            biggestDistanceYet = minDis
            bestVertex = vertex
            closest_dunkin_coord = closest_dunkin_branch

    print("The furthest away you can get from a dunkin donuts is {} km at the coordinates {}. "
          "The closest dunkin donuts would be at {}.".format(
        haversine_np(bestVertex, closest_dunkin_coord),
        bestVertex,
        closest_dunkin_coord)
    )

    # Plot everything
    fig = voronoi_plot_2d(vor, show_vertices=False, line_width=0)
    ax = fig.gca()
    ax.add_patch(plt.Circle(bestVertex, biggestDistanceYet, color='g', fill=False, linewidth=2))
    plt.plot(bestVertex[0], bestVertex[1], 'o')
    plt.ylim(40.5, 43)
    for a in polygons:
        x, y = a.exterior.xy
        plt.plot(x, y)
    ax.set_aspect('equal')
    ax.set_ylabel('Latitude')
    ax.set_xlabel('Longitude')

    plt.show()
    fig.savefig('vonoroi.png')


if __name__ == '__main__':
    print_closest_dis()
