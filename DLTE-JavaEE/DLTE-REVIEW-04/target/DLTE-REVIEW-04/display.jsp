<%--
  Created by IntelliJ IDEA.
  User: xxshetug
  Date: 3/23/2023
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Display</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: "Inter", Arial, Helvetica, sans-serif;
            background-color: #E6E6FA;
        }
        .formbold-mb-5 {
            margin-bottom: 10px;
        }
        .formbold-pt-3 {
            padding-top: 12px;
        }
        .formbold-main-wrapper, table-wrap {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 48px;
        }

        .formbold-form-wrapper,table {
            margin: 0 auto;
            max-width: 1000px;
            width: 100%;

        }
        .formbold-form-label {
            display: block;
            font-weight: 500;
            font-size: 16px;
            color: #07074d;
            margin-bottom: 12px;
        }
        .formbold-form-label-2 {
            font-weight: 600;
            font-size: 20px;
            margin-bottom: 20px;
        }

        .formbold-form-input {
            width: 100%;
            padding: 12px 24px;
            border-radius: 6px;
            border: 1px solid #e0e0e0;
            background: white;
            font-weight: 500;
            font-size: 16px;
            color: #6b7280;
            outline: none;
            resize: none;
        }
        .formbold-form-input:focus {
            border-color: #6a64f1;
            box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
        }

        .formbold-btn {
            text-align: center;
            font-size: 16px;
            border-radius: 6px;
            padding: 14px 32px;
            border: none;
            font-weight: 600;
            background-color: #6a64f1;
            color: white;
            width: 50%;
            cursor: pointer;
        }
        .formbold-btn:hover {
            box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
        }

        .formbold--mx-3 {
            margin-left: -12px;
            margin-right: -12px;
        }
        .formbold-px-3 {
            padding-left: 12px;
            padding-right: 12px;
        }
        .flex {
            display: flex;
        }
        .flex-wrap {
            flex-wrap: wrap;
        }
        .w-full {
            width: 100%;
        }
        @media (min-width: 540px) {
            .sm\:w-half {
                width: 50%;
            }
        }
        table {
            /*width: 800px;*/
            /*border-collapse: collapse;*/
            /*overflow: hidden;*/
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        .table {
            margin: auto;
            width: 80%;
        }

        th, td {
            padding: 15px;
            background-color: rgba(255,255,255,0.2);
        }

        th {
            text-align: left;
            background-color: #55608f;
        }
        tbody tr:hover {
            background-color: rgba(255,255,255,0.3);
        }
    </style>
</head>
<body>
    <script>
        let dreg;
        let studentList;
        function getByIndex(obj, index) {
            return obj[Object.keys(obj)[index]];
        }
        function deleteStudent(reg) {

                $.get( "delete?regNo="+reg, (data)=>{
                    fetchDetails();
                });


        }
        function fetchDetails(){
            $.get( "fetch", function( data ) {
                studentList = data;
                $(".rows").remove();
                $.each(studentList,function (studentindex,item) {
                    let addresses = "";
                    $.each(item.addresses, function (addressindex,address) {
                        addresses += "<td><ul><li>"+address.door_no+"</li><li>"+address.street+"</li><li>"+address.city+"</li><li>"+address.pincode+"</li><ul></td>";
                    })
                    $("tbody").append("<tr class='rows'><td>"+item.reg_no+"</td><td>"+item.name+"</td><td>"+item.age+"</td><td>"+item.email+"</td>"+addresses+"<td><button type='button' class='btn btn-danger' onclick=\"deleteStudent("+item.reg_no+")\">Delete</button></td></tr>");
                })
            });
        }
        $(function () {
            fetchDetails();
        });
        $(document).ready(function(){
            $("#btn").click(()=>{
                const regNo=$("input[name=regNo]").val();
                const name=$("input[name=name]").val();
                const age=$("input[name=age]").val();
                const email=$("input[name=email]").val();
                const cDoor=$("input[name=cDoor]").val();
                const cStreet=$("input[name=cStreet]").val();
                const cCity=$("input[name=cCity]").val();
                const cPincode=$("input[name=cPincode]").val();
                const pDoor=$("input[name=pDoor]").val();
                const pStreet=$("input[name=pStreet]").val();
                const pCity=$("input[name=pCity]").val();
                const pPincode=$("input[name=pPincode]").val();


                $.post("insert",{
                    "regNo":regNo,
                    "name":name,
                    "age":age,
                    "email":email,
                    "cDoor":cDoor,
                    "cStreet":cStreet,
                    "cCity":cCity,
                    "cPincode":cPincode,
                    "pDoor":pDoor,
                    "pStreet":pStreet,
                    "pCity":pCity,
                    "pPincode":pPincode
                },function(data){
                    fetchDetails();
                })


                $("input[name=regNo]").val("");
                $("input[name=name]").val("");
                $("input[name=age]").val("");
                $("input[name=email]").val("");
                $("input[name=cDoor]").val("");
                $("input[name=cStreet]").val("");
                $("input[name=cCity]").val("");
                $("input[name=cPincode]").val("");
                $("input[name=pDoor]").val("");
                $("input[name=pStreet]").val("");
                $("input[name=pCity]").val("");
                $("input[name=pPincode]").val("");

            })

        });
    </script>
    <div class="formbold-main-wrapper">
        <div class="formbold-form-wrapper">
            <form class="rounded-4 shadow-lg p-5">
                <div class="row">
                    <div class="col">
                        <div class="formbold-mb-5 col-sm-12">
                            <label class="formbold-form-label"> Register Number </label>
                            <input type="number" name="regNo" placeholder="Register Number" class="formbold-form-input"/>
                        </div>
                        <div class="formbold-mb-5 col-sm-12">
                            <label class="formbold-form-label"> Full Name </label>
                            <input type="text" name="name" placeholder="Enter your full name" class="formbold-form-input"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="formbold-mb-5">
                            <label class="formbold-form-label"> Age </label>
                            <input type="number" name="age" placeholder="Enter your age" class="formbold-form-input"/>
                        </div>
                        <div class="formbold-mb-5">
                            <label class="formbold-form-label"> Email Address </label>
                            <input type="email" name="email" placeholder="Enter your email" class="formbold-form-input"/>
                        </div>
                    </div>
                </div>



                <div class="row">
                    <div class="col">
                        <div class="formbold-mb-5 formbold-pt-3">
                            <label class="formbold-form-label formbold-form-label-2">
                                Permanent Address
                            </label>
                            <div class="flex flex-wrap formbold--mx-3">
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> Door No. </label>
                                        <input type="text" name="pDoor" placeholder="Enter door number" class="formbold-form-input"/>
                                    </div>
                                </div>
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> Street </label>
                                        <input type="text" name="pStreet" placeholder="Enter street" class="formbold-form-input"/>
                                    </div>
                                </div>
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> City </label>
                                        <input type="text" name="pCity" placeholder="Enter city" class="formbold-form-input"/>
                                    </div>
                                </div>
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> Pincode </label>
                                        <input type="number" name="pPincode" placeholder="Enter pincode" class="formbold-form-input"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="formbold-mb-5 formbold-pt-3">
                            <label class="formbold-form-label formbold-form-label-2">
                                Current Address
                            </label>
                            <div class="flex flex-wrap formbold--mx-3">
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> Door No. </label>
                                        <input type="text" name="cDoor" placeholder="Enter door number" class="formbold-form-input"/>
                                    </div>
                                </div>
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> Street </label>
                                        <input type="text" name="cStreet" placeholder="Enter street" class="formbold-form-input"/>
                                    </div>
                                </div>
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> City </label>
                                        <input type="text" name="cCity" placeholder="Enter city" class="formbold-form-input"/>
                                    </div>
                                </div>
                                <div class="w-full sm:w-half formbold-px-3">
                                    <div class="formbold-mb-5">
                                        <label class="formbold-form-label"> Pincode </label>
                                        <input type="number" name="cPincode" placeholder="Enter pincode" class="formbold-form-input"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <button type="reset" class="btn btn-danger">Reset</button>
                    <button type="button" id="btn" class="btn btn-success">Submit</button>
                </div>
            </form>
        </div>
    </div>
    <div class="container">
    <div class="table-wrap mb-5">
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead >
                <tr>
                    <th>Register Number</th><th>Name</th><th>Age</th>
                    <th>Email</th><th>Primary Address</th><th>Secondary Address</th><th>Option</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>


    </div>
</body>
</html>
