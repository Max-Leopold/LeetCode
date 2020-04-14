SELECT Request_at                                                     AS Day,
       ROUND(COUNT(IF(status != 'completed', 1, NULL)) / COUNT(*), 2) AS "Cancellation Rate"
FROM Trips
WHERE Client_Id NOT IN (SELECT Users_Id FROM Users Where Banned = 'Yes')
  AND Driver_Id NOT IN (SELECT Users_Id FROM Users Where Banned = 'Yes')
  AND Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY Request_at
