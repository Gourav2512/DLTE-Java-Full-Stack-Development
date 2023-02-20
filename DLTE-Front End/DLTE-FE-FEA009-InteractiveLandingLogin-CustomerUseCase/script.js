function authen(){
    //Stored Customer Details
    let arr = [
    {
        "id": "12345",
        "name":"Gourav",
        "pin":"1234",
        "status":"Success",
        "accno":"123456789",
        "balance":"1000",
        "aadhaar":"123412341234",
        "pan":"ABCD1234",
        "number":"9876543210",
        "email":"gourav@gmail.com"
     },
     {
        "id": "54321",
        "name":"Shetty",
        "pin":"4321",
        "status":"Pending",
        "accno":"987654321",
        "balance":"2000",
        "aadhaar":"567856785678",
        "pan":"EFGH1234",
        "number":"9876543211",
        "email":"shetty@gmail.com"
     }
    ]
    //Storing input from the form in variables
    let cid = document.forms['login'].id.value;
    let cname = document.forms['login'].name.value;
    let cpin = document.forms['login'].pin.value;
    let cstatus = document.forms['login'].status.value;
    let caccno = document.forms['login'].accno.value;
    let cbalance = document.forms['login'].balance.value;
    let caadhaar = document.forms['login'].aadhaar.value;
    let cpan = document.forms['login'].pan.value;
    let cnumber = document.forms['login'].number.value;
    let cemail = document.forms['login'].email.value;
     
    //If user doesn't exist
    document.getElementById("notFound").innerHTML = "User Doesn't Exist....";

    arr.forEach((item) => {
        //Checking if Customer ID exists
        if(item.id == cid){
            document.getElementById("notFound").innerHTML = "";
            //Checking for other inputs
            if(item.name==cname && item.pin==cpin && item.status==cstatus && item.accno==caccno && item.balance==cbalance && item.aadhaar==caadhaar && item.pan==cpan && item.number==cnumber && item.email==cemail){
                window.location = "http://127.0.0.1:5500/home.html";
            }
            else{
                //Checking if other details match
                if(item.name!=cname){
                    document.getElementById("name").innerHTML = "Name doesn't match";
                }
                else{
                    document.getElementById("name").innerHTML = "";
                }
                if(item.pin!=cpin){
                    document.getElementById("pin").innerHTML = "Enter the correct pin";
                }
                else{
                    document.getElementById("pin").innerHTML = "";
                }
                if(item.status!=cstatus){
                    document.getElementById("status").innerHTML = "Incorrect status";
                }
                else{
                    document.getElementById("status").innerHTML = "";
                }
                if(item.accno!=caccno){
                    document.getElementById("accno").innerHTML = "Account number is incorrect";
                }
                else{
                    document.getElementById("accno").innerHTML = "";
                }
                if(item.balance!=cbalance){
                    document.getElementById("balance").innerHTML = "Incorrect Balance";
                }
                else{
                    document.getElementById("balance").innerHTML = "";
                }
                if(item.aadhaar!=caadhaar){
                    document.getElementById("aadhaar").innerHTML = "Aadhaar number doesn't match";
                }
                else{
                    document.getElementById("aadhaar").innerHTML = "";
                }
                if(item.pan!=cpan){
                    document.getElementById("pan").innerHTML = "PAN doesn't match";
                }
                else{
                    document.getElementById("pan").innerHTML = "";
                }
                if(item.number!=cnumber){
                    document.getElementById("number").innerHTML = "Contact number is incorrect";
                }
                else{
                    document.getElementById("number").innerHTML = "";
                }
                if(item.email!=cemail){
                    document.getElementById("email").innerHTML = "Email is incorrect";
                }
                else{
                    document.getElementById("email").innerHTML = "";
                }
            }      
          }
    });

}