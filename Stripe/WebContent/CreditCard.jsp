<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <title>Credit Card</title>

  <!-- Styles -->
  <link href='https://fonts.googleapis.com/css?family=Roboto:400,300,100' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="style.css">
  <meta name="robots" content="noindex,follow" />
</head>

<body>
    <form class="credit-card" method="post" action="HomeController">
      <div class="form-header">
        <h4 class="title">Credit card detail</h4>
      </div>

      <div class="form-body">
        <!-- Card Number -->
        <input type="text" name="cardnumber" class="card-number" placeholder="Card Number">

        <!-- Date Field -->
        <div class="date-field">
          <div class="month">
            <select name="Month">
              <option value="1">January</option>
              <option value="2">February</option>
              <option value="3">March</option>
              <option value="4">April</option>
              <option value="5">May</option>
              <option value="6">June</option>
              <option value="7">July</option>
              <option value="8">August</option>
              <option value="9">September</option>
              <option value="10">October</option>
              <option value="11">November</option>
              <option value="12">December</option>
            </select>
          </div>
          <div class="year">
            <select name="Year">
              <option value="2016">2016</option>
              <option value="2017">2017</option>
              <option value="2018">2018</option>
              <option value="2019">2019</option>
              <option value="2020">2020</option>
              <option value="2021">2021</option>
              <option value="2022">2022</option>
              <option value="2023">2023</option>
              <option value="2024">2024</option>
            </select>
          </div>
        </div>

        <!-- Card Verification Field -->
        <div class="card-verification">
          <div class="cvv-input">
            <input name="cvv" type="text" placeholder="CVV">
          </div>
          <div class="cvv-details">
            <p>3 or 4 digits usually found <br> on the signature strip</p>
          </div>
        </div>

        <!-- Buttons -->
        <button type="submit" class="proceed-btn"><a href="#">Proceed</a></button>
      </div>
    </form>
</body>

</html>
