<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <title>Insert</title>
</head>
<body>

<form method="post" action="insert">
    <div class="mb-3">
        <label class="form-label">Register Number</label>
        <input type="number" class="form-control" name="reg_no">
    </div>
    <div class="mb-3">
        <label  class="form-label">Name</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="mb-3">
        <label  class="form-label">Age</label>
        <input type="number" class="form-control" name="age">
    </div>
    <div class="mb-3">
        <label  class="form-label">Email</label>
        <input type="text" class="form-control" name="email">
    </div>
    <div class="mb-3">
        <label  class="form-label">Door Number</label>
        <input type="text" class="form-control" name="door1">
    </div>
    <div class="mb-3">
        <label  class="form-label">Street</label>
        <input type="text" class="form-control" name="street1">
    </div>
    <div class="mb-3">
        <label  class="form-label">City</label>
        <input type="text" class="form-control" name="city1">
    </div>
    <div class="mb-3">
        <label  class="form-label">Pincode</label>
        <input type="number" class="form-control" name="pincode1">
    </div>
    <div class="mb-3">
        <label  class="form-label">Door Number</label>
        <input type="text" class="form-control" name="door2">
    </div>
    <div class="mb-3">
        <label  class="form-label">Street</label>
        <input type="text" class="form-control" name="street2">
    </div>
    <div class="mb-3">
        <label  class="form-label">City</label>
        <input type="text" class="form-control" name="city2">
    </div>
    <div class="mb-3">
        <label  class="form-label">Pincode</label>
        <input type="number" class="form-control" name="pincode2">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
 <a href="display.jsp">Display</a>
</body>
</html>
