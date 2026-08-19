# Write your MySQL query statement below
SELECT e.name 
FROM Employee e
JOIN Employee emp
ON e.id = emp.managerId
GROUP BY e.id, e.name
HAVING COUNT(e.id) >= 5;