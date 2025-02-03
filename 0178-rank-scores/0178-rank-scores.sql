# Write your MySQL query statement below
SELECT score, dense_rANK() OVER (ORDER BY score DESC) AS "rank"
FROM Scores
ORDER BY score DESC;


