SELECT a.Id
FROM Weather AS a
         JOIN Weather AS b
              ON b.RecordDate = a.RecordDate - INTERVAL 1 DAY AND b.Temperature < a.Temperature
