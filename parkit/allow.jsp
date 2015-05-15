<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>Real-time Parking Management System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style1.css">


    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                      <h1><span class="red">Real-time Parking Management System.</span></h1>
                    </div>
                     <div class="links span8">
                         <a href="home.html" rel="tooltip" data-placement="bottom" data-original-title="Home"><span class=red>Home</span></a>
                        <!--<a class="" href="" rel="tooltip" data-placement="bottom" data-original-title="book"></a>-->
                        <a href="book.html" rel="tooltip" data-placement="bottom" data-original-title="book"><span class=red>Book</span></a>
                        <a href="service.html" rel="tooltip" data-placement="bottom" data-original-title="book"><span class=red>Services</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="verify.jsp" rel="tooltip" data-placement="bottom" data-original-title="verify"><span class=red>Verify</span></a>
                        
                    </div>
                    
                </div>
            </div>
        </div>

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="img/banner.png" alt="">
                    <img src="img/slide-2.jpg" alt="">
                    <img src="img/big9.jpg" alt="">
                </div>
                <div class="register span6">
                    <h2> Your are Allowed to Park</h2>
                   <form action="VerifyServlet" method="post">
                        <label for="carno">Car Number</label>
                        <input type="text" id="carno" name="nplate" placeholder="Enter your car number(ex:TN11Y0016)...">
                        <button type="submit" value="verify">VERIFY</button>
                   </form>
                                     
                </div>
                <div class="reg"></div>
            </div>
        </div>

        <!-- Javascript -->
            <!--<script src="js/jquery-1.8.2.min.js"></script>-->
        <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
       <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>

    </body>

</html>

