<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Address</title>
    <link rel="stylesheet" href="style1.css">
    <link rel="icon" href="images/logol.png" type="image/png">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
</head>
<body>
    

<%@ include file = "header.html" %>   
      </div>
    </div>
    </div>
</form>
<!-- header section ends here -->


<script language="JavaScript">
function validate(form) {
    if (form.streetAddress.value === "") {
        alert("Please enter your Street Address.");
        form.streetAddress.focus();
    } else if (form.apartmentNumber.value === "") {
        alert("Please enter your Apartment Number.");
        form.apartmentNumber.focus();
    } else if (form.zipCode.value === "") {
        alert("Please enter your Zip Code.");
        form.zipCode.focus();
    } else {
        form.submit();
    }
}
</script>


<div class="formdetails">
        <h1>Please Enter your Address Details Below</h1>
<form action="AddressServlet" method="post">
            <table cellspacing="5" border="0">
    <tr>
      <td align="right">Street Address:</td>
      <td><input type="text" name="streetAddress" placeholder="e.g. Mbagathi Way" style="padding: 8px; width: 250px;" required></td>
    </tr>
    <tr>
      <td align="right">Apartment Number:</td>
      <td><input type="text" name="apartmentNumber" placeholder="e.g. Apt 21B" style="padding: 8px; width: 250px;" required></td>
    </tr>
    <tr>
      <td align="right">City:</td>
      <td><input type="text" name="city" placeholder="e.g. Nairobi" style="padding: 8px; width: 250px;" required></td>
    </tr>
    <tr>
      <td align="right">Zip Code:</td>
      <td><input type="text" name="zipCode" placeholder="e.g. 00100" style="padding: 8px; width: 250px;" required></td>
    </tr>
    <tr>
      <td align="right">Additional Notes:</td>
      <td><textarea name="additionalNotes" placeholder="Any additional information..." style="padding: 8px; width: 250px;" rows="4"></textarea></td>
    </tr>
    <tr>
      <td></td>
      <td><br><input type="submit" value="Submit" onclick=validate(this.form) style="padding: 10px 20px; background-color: #07a737; color: white; border: none; border-radius: 4px; cursor: pointer;"></td>
    </tr>
    </table>
 </form>
</div>

     
<%@ include file = "footer.jsp" %>

  <style>
      body {
        margin: 0;
        padding: 0;
        font-family: 'Montserrat', sans-serif;
        background: url(images/background.png);
            background-size: cover;
            background-position: center;
    }
    .formdetails{
    margin-top: 7rem;
    margin-bottom: 3rem;
  }
  .formdetails h1{
    text-align: center;
    font-size: 1.5rem;
    padding-bottom: 2rem;
  }
    form {
        max-width: 400px;
        margin: auto;
        padding: 20px;
        border: 1px solid #000000;
        border-radius: 5px;
        font-family: 'Montserrat', sans-serif;
    }
    form input, form textarea{
        border: 1px solid #717171;
        border-radius: 4px;
        display: block;
        font-size: 15px;
        padding: 9px;
        width: 100%;
    }
    label, input, textarea {
        display: block;
        margin-bottom: 10px;
    }
    input[type="submit"] {
        background-color: #333;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #555;
    }
 </style>

</body>
</html>
