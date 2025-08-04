# Write your MySQL query statement below
SELECT A.unique_id, B.name
FROM Employees as B LEFT JOIN EmployeeUNI as A ON A.id =  B.id;