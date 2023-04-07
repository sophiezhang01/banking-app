const url = "http://localhost:3000/"

//document.getElementById("backButton").addEventListener("click", back);
document.getElementById("register-btn").addEventListener("click", create);

function back(){
    // document.getElementById("text").innerText="GOING TO THE MAIN PAGE";   
    window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/login.html";
    }

async function create(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    let userfn = document.getElementById("fname").value;
    let userln = document.getElementById("lname").value;
    let userea = document.getElementById("email").value;
    let selectedValue = document.getElementById("currentrole").value;
    

    let users = {
        username:usern,
        password:userp,
        fname:userfn,
        lname:userln,
        email:userea,
        role_id: selectedValue
    }
    console.log(users)

    let response = await fetch(url + "users/register", {

        method: "POST", 
        body: JSON.stringify(users), 
        credentials: "include"
    });

    if(response.status === 201) {
        document.getElementById("text").innerText="USER SUCCESSFULLY ADDED";
         window.setTimeout(function(){window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/home.html";}, 3000);

    } else {
        document.getElementById("text").innerText="USERNAME ALREADY EXIST! - PLEASE TRY AGAIN";
        window.setTimeout(function(){window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/register.html";}, 3000);
    }
}