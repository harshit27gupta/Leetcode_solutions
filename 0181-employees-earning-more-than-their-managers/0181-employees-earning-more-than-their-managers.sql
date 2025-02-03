# Write your MySQL query statement below
-- SELECT e.name AS Employee FROM Employee e JOIN Employee m ON e.managerId = m.id WHERE e.salary > m.salary;
Select e.name as employee from Employee as e join Employee as e1 on e.managerId=e1.id where e.salary>e1.salary;