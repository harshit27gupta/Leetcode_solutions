# Write your MySQL query statement below
WITH TripStatus AS (
  SELECT 
    Request_at AS Day, 
    T.status != 'completed' AS cancelled 
  FROM 
    Trips T 
    JOIN Users C ON Client_Id = C.Users_Id 
    AND C.Banned = 'No' 
    JOIN Users D ON Driver_Id = D.Users_Id 
    AND D.Banned = 'No' 
  WHERE 
    Request_at BETWEEN '2013-10-01' 
    AND '2013-10-03'
) 
SELECT 
  Day, 
  ROUND(
    SUM(cancelled) / COUNT(cancelled), 
    2
  ) AS 'Cancellation Rate' 
FROM 
  TripStatus 
GROUP BY 
  Day;
