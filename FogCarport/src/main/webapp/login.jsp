
<div class="container-fluid">
    <div class="row no-gutter">
        <!-- Background image -->
        <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
        <div class="col-md-8 col-lg-6">
            <div class="login d-flex align-items-center py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9 col-lg-8 mx-auto">
                            <!-- HEADLINE -->
                            <h3 class="login-heading mb-4">Fog Carporte - Login</h3>
                            <form method="POST" action="FrontController">

                                <!-- COMMAND -->
                                <input type="hidden" name="command" value="login">

                                <!-- EMAIL -->
                                <div class="form-label-group">
                                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus name="email">
                                    <label for="inputEmail">Email</label>
                                </div>

                                <!-- PASSWORD -->
                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
                                    <label for="inputPassword">Password</label>
                                </div>

                                <!-- BUTTON-->
                                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2 btnlogincolor" type="submit">
                                    Log ind
                                </button>

                                <!-- LINK TO CREATE USER -->
                                <div class="text-center">
                                    <a class="small" href="FrontController?command=link&link=createUser">Opret Bruger</a></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
