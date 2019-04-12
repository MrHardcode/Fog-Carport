<%-- 
    Document   : makeCarport
    Created on : 12-04-2019, 16:39:35
    Author     : Malte
--%>

<jsp:include page='/header.jsp'></jsp:include>

    <!-- Form start -->
    <form action=" TO BE DETERMINED " method="post" class="orderForm">
        
        <!-- Length -->
        <div class="orderForm">
        <label for="lengthinput">Length</label>
        <input type="number" id="lengthinput" name="length" placeholder="Length">
        </div>
        
        <!-- Width -->
        <div class="orderForm">
        <label for="widthinput">Width</label>
        <input type="number" id="widthinput" name="width" placeholder="Width">
        </div>
        
        <!-- Height -->
        <div class="orderForm">
        <label for="heightinput">Height</label>
        <input type="number" id="heightinput" name="height" placeholder="Height">
        </div>
        
        <!-- button -->
        <button type="submit" name="submit" class="orderForm">Order</button>
        <!-- Form end -->
    </form>

<jsp:include page='/footer.jsp'></jsp:include>