document.getElementById("registerForm").addEventListener("submit", async function (event) {
    event.preventDefault();

    const customerName = document.getElementById("customerName").value;
    const customerEmail = document.getElementById("customerEmail").value;
    const password = document.getElementById("password").value;

    const customer = {
        customerName,
        customerEmail,
        password,
    };

    try {
        const response = await fetch("http://localhost:8080/customers/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(customer),
        });

        if (response.status === 201) {
            alert("Registration successful!");
            window.location.href = "http://localhost:8080/index.html"; // Redirect to login page after successful registration
        } else {
            alert("Registration failed!");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Registration failed!");
    }
});