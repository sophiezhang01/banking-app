const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints

//add eventListeners to our buttons to give them functionality
document.getElementById("login-btn").addEventListener("click", login);

//this function will send the user-inputted login credentials to our server
async function login() {

    //gather the user inputs from the login inputs
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let user = {
        username:usern,
        password:userp
    }

    // export {user};
    //This object will reflect our DTO in Java... This is the data we want to transfer!
    console.log(user)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!

    let response = await fetch(url + "login", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(user), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });

    //control flow based on successful/unsuccessful login
    if(response.status === 200) {
        document.getElementById("text").innerText="Welcome!!!";
         window.setTimeout(function(){window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/home.html";}, 3000);
     
    } 
    // else if (response.status === 202){
    //     document.getElementById("text").innerText="Welcome!!!";
    //     window.setTimeout(function(){window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/manager.html";}, 3000);
     
    // }
    else {
        document.getElementById("text").innerText="LOGIN FAILED! PAGE WILL AUTOMATICALLY REFRESH";
        window.setTimeout(function(){window.location.href = "file:///C:/Users/sophie/Documents/MaxxPotential/bankingApp/frondend/login.html";}, 3000);
    }

    // localStorage.setItem("actualuser", usern);

    // let response2 = await fetch(url + "user/author/" + usern);
    // let data2 = await response2.json();
    // localStorage.setItem("intauthor", data2);

}



