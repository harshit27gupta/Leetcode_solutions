WITH RankedSalaries AS (
    SELECT 
        e.name AS employee, 
        e.salary, 
        d.name AS Department,
        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS salary_rank
    FROM Employee e
    JOIN Department d 
        ON e.departmentId = d.id
)
SELECT 
    Department,
    employee, 
    salary
FROM RankedSalaries
WHERE salary_rank <= 3
ORDER BY Department, salary DESC;
