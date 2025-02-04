# Write your MySQL query statement below
Select name from SalesPerson where sales_id not in
(Select s.sales_id from SalesPerson as s inner join Orders as o on s.sales_id=o.sales_id where
 o.com_id=(Select com_id from Company where name="RED"));