
document.getElementById('evaluateRuleForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    const ruleId = document.getElementById('ruleId').value;
    const userData = JSON.parse(document.getElementById('userData').value);

    // Fetch the rule using the ruleId
    fetch(`http://localhost:8080/api/rules/${ruleId}`)
        .then(response => response.json())
        .then(rule => {
            const ruleAst = rule.ruleAst; // Get the AST from the rule

            // Now evaluate the rule with the user data
            return fetch('http://localhost:8080/api/rules/evaluate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    userData: userData,
                    ruleAst: ruleAst // Use the actual rule AST here
                })
            });
        })
        .then(response => response.json())
        .then(data => {
            // Change this line to stringify the result
            document.getElementById('evaluateRuleResult').innerText = 'Evaluation Result: ' + JSON.stringify(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
