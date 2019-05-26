/*----------------- Navbar JS -----------------  */

/*----------------- OrderValidation JS -----------------  */

//document.addEventListener("DOMContentLoaded", calculateOperationMargin);
//document.addEventListener("DOMContentLoaded", fillDropdownsDimensions);

// instead of window.location we check if a page-specific element exists before 
// methods are called
document.addEventListener("DOMContentLoaded", function () {
    if (document.getElementById("varpriceinput") !== null) {
        calculateOperationMarginSuggestedPrice();
    }
    if (document.getElementById("suggestedretailprice") !== null){
        checkPriceOffer(); 
    }
    fillDropdownsDimensions();
});
if (document.getElementById("varpriceinput") !== null) {
    let varpriceinput = document.getElementById("varpriceinput");
    varpriceinput.addEventListener("keyup", function () {
        calculateOperationsMarignVariblePrice();
    });
}

// Added to only run the SVG-related JS when command=viewSVG
document.addEventListener("DOMContentLoaded", function () {
    if (window.location.toString().indexOf("command=viewSVG") !== -1) {
        checkRadioButtons();
    }
});


function fillDropdownsDimensions() {
    let lengthOption = document.getElementById('input-length');
    let widthOption = document.getElementById('input-width');
    for (let i = 240; i < 750; i = i + 30) {
        lengthOption.innerHTML += '<option value="' + (i * 10) + '">' + i + ' cm</option>';
        widthOption.innerHTML += '<option value="' + (i * 10) + '">' + i + ' cm</option>';
    }
}
;

let inputlength = document.getElementById("input-length");
let inputwidth = document.getElementById("input-width");
let inputincline = document.getElementById("roof-inclines");
let inputrooftiles = document.getElementById("roof-tiles");
let inputadress = document.getElementById("inputAddress");
let inputname = document.getElementById("inputName");
let inputemail = document.getElementById("inputEmail");
let inputphone = document.getElementById("inputPhoneNumber");
let inputzip = document.getElementById("inputZip");
let submit = document.getElementById("submit-btn");
//Shed options
let lengthOptions = document.getElementById("shed-length");
let widthOptions = document.getElementById("shed-width");
let floorOptions = document.getElementById("shed-floor");
let wallOptions = document.getElementById("shed-wall");

let shedCheckBox = document.getElementById("check-skur");
shedCheckBox.addEventListener("click", function(){
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});

inputlength.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputwidth.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputincline.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputrooftiles.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputadress.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputname.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputemail.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputphone.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
inputzip.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
lengthOptions.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
widthOptions.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
floorOptions.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});
wallOptions.addEventListener("change", function () {
    if (shedCheckBox.checked === false)
    {
        validateInputNoShed();
    }
    else
    {
        validateAllInput();
    }
});

function validateAllInput() {
    let lengthOptionsValue = lengthOptions.options[lengthOptions.selectedIndex].value;
    let widthOptionsValue = widthOptions.options[widthOptions.selectedIndex].value;
    let floorOptionsValue = floorOptions.options[floorOptions.selectedIndex].value;
    let wallOptionsValue = wallOptions.options[wallOptions.selectedIndex].value;
    let inputLengthValue = inputlength.options[inputlength.selectedIndex].value;
    let inputWidthValue = inputwidth.options[inputwidth.selectedIndex].value;
    let inputInclineValue = inputincline.options[inputincline.selectedIndex].value;
    let inputRooftilesValue = inputrooftiles.options[inputrooftiles.selectedIndex].value;
    let inputAdressValue = inputadress.value;
    let inputNameValue = inputname.value;
    let inputEmailValue = inputemail.value;
    let inputPhoneValue = inputphone.value;
    let inputZipValue = inputzip.value;

    if (inputLengthValue !== "" && inputWidthValue !== "" &&
            inputInclineValue !== "" && inputRooftilesValue !== "" &&
            inputAdressValue !== "" && inputNameValue !== "" &&
            inputEmailValue !== "" && inputPhoneValue !== "" &&
            inputZipValue !== "" && lengthOptionsValue !== "" && 
            widthOptionsValue !== "" && floorOptionsValue !== "" && 
            wallOptionsValue !== "") {
        submit.classList.remove("disabled");
        submit.removeAttribute("disabled");
    } else {
        submit.classList.add("disabled");
        submit.setAttribute("disabled", "disabled");
    }
}

function validateInputNoShed() {

    let inputLengthValue = inputlength.options[inputlength.selectedIndex].value;
    let inputWidthValue = inputwidth.options[inputwidth.selectedIndex].value;
    let inputInclineValue = inputincline.options[inputincline.selectedIndex].value;
    let inputRooftilesValue = inputrooftiles.options[inputrooftiles.selectedIndex].value;
    let inputAdressValue = inputadress.value;
    let inputNameValue = inputname.value;
    let inputEmailValue = inputemail.value;
    let inputPhoneValue = inputphone.value;
    let inputZipValue = inputzip.value;

    if (inputLengthValue !== "" && inputWidthValue !== "" &&
            inputInclineValue !== "" && inputRooftilesValue !== "" &&
            inputAdressValue !== "" && inputNameValue !== "" &&
            inputEmailValue !== "" && inputPhoneValue !== "" &&
            inputZipValue !== "") {
        submit.classList.remove("disabled");
        submit.removeAttribute("disabled");
    } else {
        submit.classList.add("disabled");
        submit.setAttribute("disabled", "disabled");
    }
}

/*----------------- OrderValidation[CARPORT_ROOF] JS -----------------  */

document.addEventListener("DOMContentLoaded", prepareInclineMenu); //once website is partially, load the incline options

/* Add roof incline options to the dropdown*/
let inclineOptions = document.getElementById('roof-inclines');
function prepareInclineMenu() {
    let roofInclineOptions = [0, 5, 10, 15, 20, 25, 30, 35, 40, 45];
    for (let i = 0; i < roofInclineOptions.length; i++) {
        inclineOptions.innerHTML += '<option value="' + roofInclineOptions[i] + '">' + roofInclineOptions[i] + '&#176</option>';
    }
}
;

/* get and disable roof tile selection */
let tileOption = document.getElementById("roof-tiles");
tileOption.disabled = true;//by default we disable the tile selection

/* When selection of incline changes, delete deprecated data from tile-selection dropdown */
inclineOptions.addEventListener("change", function () {
    clearOptions(document.getElementById("roof-tiles"));
});

/* When incline option is selected, check selected option */
inclineOptions.addEventListener("change", function () {
    checkInclineMenuState();
});



let inclineOptionsChoice = document.getElementById("roof-inclines").selected;
let flatroofid = document.getElementsByClassName("flat-roof-id");
let flatroofname = document.getElementsByClassName("flat-roof-name");
let raisedroofid = document.getElementsByClassName("raised-roof-id");
let raisedroofname = document.getElementsByClassName("raised-roof-name");

function checkInclineMenuState() {
    //I am using double == instead of triple === on purpose 
    if (inclineOptions.selectedIndex == 0)
    {
        //document.getElementById("roof-tiles").disabled = true;
        tileOption.disabled = true;
    } else
    {
        tileOption.disabled = false;
        //document.getElementById("roof-tiles").disabled = false;
        prepareTileMenu();
    }
}

function prepareTileMenu()
{
    if (inclineOptions.selectedIndex == 1) //plastic, flat roof
    {
        for (let i = 0; i < flatroofid.length; i++) {
            tileOption.innerHTML += '<option value="' + flatroofid[i].value + '">' + flatroofname[i].value + '</option>';
        }
    } else // raised roof.
    {
        for (let i = 0; i < raisedroofid.length; i++) {
            tileOption.innerHTML += '<option value="' + raisedroofid[i].value + '">' + raisedroofname[i].value + '</option>';
        }
    }
    //set roof materials on the request attributes.
}

/*Remove all but the first option */
function clearOptions(dropdownmenu)
{
    while (dropdownmenu.length > 1) {
        dropdownmenu.remove(1);
    }
}


/*----------------- OrderValidation[SHED] JS -----------------  */
let len = document.getElementById("input-length").selected;
let wid = document.getElementById("input-width").selected;


document.getElementById("check-skur").addEventListener("click", checkShedMenuVisibility);
document.getElementById("check-skur").disabled = true;

//elements from OrderValidation.js
inputlength.addEventListener("change", function () {
    checkMenuState();
});
inputwidth.addEventListener("change", function () {
    checkMenuState();
});

function checkMenuState() {
    //I am using double == instead of triple === on purpose 
    if (inputlength.selectedIndex == "0" || inputwidth.selectedIndex == "0")
    {
        document.getElementById("check-skur").disabled = true;
        document.getElementById("check-skur").checked = false;
        checkShedMenuVisibility();
    } else
    {
        document.getElementById("check-skur").disabled = false;
        clearShedDimensionsMenu();
        prepareShedMenu();
    }
}

function checkShedMenuVisibility() {
    //The variable x represents the small checkbox on makeCarport.jsp
    let x = document.getElementById("check-skur").checked;
    //If the x is checked then x == true
    if (x)
    {
        //Making the shed-form visible by removing the cheeky little "hidden"-attribute
        let div = document.getElementById("carport-shed-div");
        div.removeAttribute("hidden");
        //Clearing menu in case the menu was already filled
        clearShedDimensionsMenu();
        //Preparing the dropdowns with options for the shed
        prepareShedMenu();
    } else
    {
        //Making the shed-form disappear
        let div = document.getElementById("carport-shed-div");
        div.setAttribute("hidden", "hidden");
        //Clearing the dropdowns for the shed
        clearShedDimensionsMenu();
    }
}


function prepareShedMenu() {

    //Getting the given dimensions of the carport
    let carportLength = (document.getElementById("input-length").value) / 10;
    let carportWidth = (document.getElementById("input-width").value) / 10;

    //Creating arrays used in the fillDropDownShedDimensions() method
    let shedLength = createShedDimensions(carportLength);
    let shedWidth = createShedDimensions(carportWidth);

    function createShedDimensions(e) {
        //Creating empty array of values for a dropdown menu 
        let sValues = [];
        //Counter used in the creation of numbers for the array
        i = 1;
        //while(true) - We keep going untill we have enough values in the array 
        while (true) {
            if (i === 1)
            {
                i = 4;
            }
            //We subtract 30 from the given length/width so the shed options follow the 
            //same pattern as the main carport construction
            sValues[i] = e - 30 * ([i]);
            if (sValues[i] <= 120)
            {
                //If the current values in the array "sValues" is less than 0 - that means
                //that no initial value was given (no value for the carport's base construction was given)
                //This means that no options should be available in the dropdowns for the shed
                if (sValues[i] < 0)
                {
                    //Clear the select-options
                    sValues = [];
                }
                //No more looping needed
                break;
            }
            i++;
        }
        return sValues;
    }

    fillDropDownShedDimensions();

    function fillDropDownShedDimensions() {
        //This enhanced loop creates a new option in the select for the shed-dimensions
        for (i in shedLength) {
            lengthOptions.options[lengthOptions.options.length] = new Option(shedLength[i], shedLength[i] * 10);
        }
        //This enhanced loop creates a new option in the select for the shed-dimensions
        for (j in shedWidth) {
            widthOptions.options[widthOptions.options.length] = new Option(shedWidth[j], shedWidth[j] * 10);
        }
    }
}

function clearShedDimensionsMenu() {
    //Clearing out the options in the selects in the shed-form
    let length = lengthOptions.options.length;
    for (k = 0; k < length; k++) {
        //We always remove the element at index 1 because the amount of options decrease 
        //every time we remove an item (like removing the item second from the bottom in a stack)
        //We remove everthing except the "Vælg længde/bredde"-option which always has to be there 
        //for the sake of user friendliness
        lengthOptions.remove(1);
    }
    let width = widthOptions.options.length;
    for (u = 0; u < width; u++) {
        widthOptions.remove(1);
    }
}

/*----------------- ViewOrder JS -----------------  */
function calculateOperationMarginSuggestedPrice() {
    let suggestedprice = parseFloat(document.getElementById("suggestedretailprice").innerHTML);
    let costprice = parseFloat(document.getElementById("costprice").innerHTML);
    let operationMargin = parseFloat(((suggestedprice / costprice) * 100) - 100).toFixed(1);
    document.getElementById("operationmargin").innerHTML = operationMargin;
}
function calculateOperationsMarignVariblePrice() {
    let varprice = document.getElementById("varpriceinput").value;
    if (varprice < 1 || isNaN(varprice)) {
        document.getElementById("varpricemargin").innerHTML = '';
        return;
    }
    let costprice = document.getElementById("costprice").innerHTML;

    let varOperationMargin = parseFloat(((varprice / costprice) * 100) - 100).toFixed(1);
    document.getElementById("varpricemargin").innerHTML = varOperationMargin;
}

// new method called in checkPriceOffer, to set the margin in "Dækningsgrad for tilbudspris:"
// after checkPriceOffer have run
function calculateOperationMarginFinalOfferPrice() {
    let finalOfferPrice = document.getElementById("priceoffer").innerHTML;
    let costprice = document.getElementById("costprice").innerHTML;
    let finalOfferoperationMargin = parseFloat(((finalOfferPrice / costprice) * 100) - 100).toFixed(1);
    document.getElementById("offerpricemargin").innerHTML = finalOfferoperationMargin;
}

function checkPriceOffer()
{
    let priceOffer = document.getElementById("priceoffer");
    if (priceOffer)
    {
        let suggestedPrice = document.getElementById("suggestedretailpriceTOSTRING");
        suggestedPrice.style.setProperty("text-decoration", "line-through");
        suggestedPrice.style.setProperty("color", "red");
        calculateOperationMarginFinalOfferPrice();
    }
}

/*----------------- ViewSVG JS -----------------  */

function checkRadioButtons() {
    let toggleBaseShow = document.getElementById("radio-base-show");
    let toggleBaseHide = document.getElementById('radio-base-hide');

    let toggleRoofShow = document.getElementById('radio-roof-show');
    let toggleRoofHide = document.getElementById('radio-roof-hide');

    let baseButton = document.getElementById('base-toggle-access');
    let roofButton = document.getElementById('roof-toggle-access');


    toggleBaseShow.addEventListener("click", function () {
        if (!toggleBaseShow.classList.contains("active"))
        {
            baseButton.click();
        }
    });

    toggleBaseHide.addEventListener("click", function () {
        if (!toggleBaseHide.classList.contains("active"))
        {
            baseButton.click();
        }
    });

    toggleRoofShow.addEventListener("click", function () {
        if (!toggleRoofShow.classList.contains("active"))
        {
            roofButton.click();
        }
    });

    toggleRoofHide.addEventListener("click", function () {
        if (!toggleRoofHide.classList.contains("active"))
        {
            roofButton.click();
        }
    });
}