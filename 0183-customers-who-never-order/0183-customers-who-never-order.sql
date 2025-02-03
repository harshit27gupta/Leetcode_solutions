# Write your MySQL query statement below
Select distinct c.name as Customers from Customers as c left join Orders on c.id=Orders.customerId where Orders.id is null;