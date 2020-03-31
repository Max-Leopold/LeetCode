SELECT a.Name AS Employee from Employee AS a
JOIN Employee AS b
ON a.ManagerId = b.Id AND a.Salary > b.Salary
