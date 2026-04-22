function login() {
   
    // You can perform login validation and authentication here
    // For simplicity, let's just display an alert
    let username =
        (document.getElementById("loginUsername") || document.getElementById("username")).value.trim();
    let password =
        (document.getElementById("loginPassword") || document.getElementById("password")).value.trim();

    if (username === "" || password === "") {
        alert("All fields are required!");
        return false;
    }

    console.log(`Login clicked. Username: ${username}, Password: ${password}`);
}

function register() {
   

    // Frontend validation for registration form
    

    // Validate email format
    
    // Validate username (no special characters)
    

    // Validate password (at least 8 characters, one capital letter, and one numeric)
    let inputs = document.querySelectorAll("input");

    let name = document.getElementById("name") ? document.getElementById("name").value.trim() : inputs[0].value;
    let email = document.getElementById("email") ? document.getElementById("email").value.trim() : inputs[1].value;
    let username = document.getElementById("username") ? document.getElementById("username").value.trim() : inputs[2].value;
    let password = document.getElementById("password") ? document.getElementById("password").value.trim() : inputs[3].value;

    // Empty field check
    if (name === "" || email === "" || username === "" || password === "") {
        alert("All fields are mandatory!");
        return false;
    }

    // Email validation
    const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) {
        alert("Enter a valid email address!");
        return false;
    }

    // Username validation (no special characters)
    const usernamePattern = /^[a-zA-Z0-9]+$/;
    if (!username.match(usernamePattern)) {
        alert("Username should not contain special characters!");
        return false;
    }

    // Password validation
    const passwordPattern = /^(?=.*[A-Z])(?=.*[0-9]).{8,}$/;
    if (!password.match(passwordPattern)) {
        alert("Password must be at least 8 characters long, include one uppercase letter and one number.");
        return false;
    }

    console.log(`Register clicked. Name: ${name}, Email: ${email}, Username: ${username}, Password: ${password}`);
    
}
module.exports = { login, register };
