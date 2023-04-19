const url = "http://localhost:3000/"

document.getElementById("createButton").addEventListener("click", create);

async function create(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    let userfn = document.getElementById("fname").value;
    let userln = document.getElementById("lname").value;
    let userea = document.getElementById("email").value;
    let selectedValue = document.getElementById("role_id").value;
    

    let user = {
        username:usern,
        password:userp,
        fname:userfn,
        lname:userln,
        email:userea,
        role_id: selectedValue
    }
    console.log(user)

    let response = await fetch(url + "user", {

        method: "POST", 
        body: JSON.stringify(user),
        credentials: "include"
    });

    if(response.status === 201) {
        document.getElementById("text").innerText="USER SUCCESSFULLY ADDED";
         window.setTimeout(function(){window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/register.html";}, 3000);

    } else {
        document.getElementById("text").innerText="USERNAME ALREADY EXIST! - PLEASE TRY AGAIN";
        window.setTimeout(function(){window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/register.html";}, 3000);
    }
}