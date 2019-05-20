/*----------------- Navbar JS -----------------  */

/*----------------- OrderValidation JS -----------------  */

document.addEventListener("DOMContentLoaded", fillDropdownsDimensions);

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
let submit = document.getElementById("submit-btn");

inputlength.addEventListener("change", function () {
    ValidateCarportInput();
});
inputwidth.addEventListener("change", function () {
    ValidateCarportInput();
});

function ValidateCarportInput() {

    let inputLengthValue = inputlength.options[inputlength.selectedIndex].value;
    let inputWidthValue = inputwidth.options[inputwidth.selectedIndex].value;

    if (inputLengthValue !== "" && inputWidthValue !== "") {
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

let tileOption = document.getElementById("roof-tiles");
tileOption.disabled = true;//by default we disable the tile selection



inclineOptions.addEventListener("change", function () {
    checkInclineMenuState();
});

let inclineOptionsChoice = document.getElementById("roof-inclines").selected;

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
//        let flatRoofOptions = {
//            '28': 'Plastmo Ecolite (Blåtonet)'
//        };
//
//        let keys = Object.keys(foo);
//        keys.forEach(tileOption.innerHTML += '<option value="' + keys.push()+ '">' + roofInclineOptions[i] + '&#176</option>');

        tileOption.innerHTML += '<option value="' + 28 + '">' + "Plastmo Ecolite (Blåtonet)" + '</option>';

    } else // raised roof.
    {
        let roofTileOptions = new Map();
        roofTileOptions.set(33, "B & C Dobbelt Tagsten (Sort)");
        roofTileOptions.set(34, "B & C Dobbelt Tagsten (Grå)");
        roofTileOptions.set(35, "Eternit Tagsten(Teglrød)");
        roofTileOptions.set(36, "B & C Dobbelt Tagsten (Rød)");
        roofTileOptions.set(37, "B & C Dobbelt Tagsten (Blå)");
        roofTileOptions.set(38, "B & C Dobbelt Tagsten (Sortblå)");
        roofTileOptions.set(39, "B & C Dobbelt Tagsten (Sunlux)");
        for (let i = 33; i <= 39; i++) {
            tileOption.innerHTML += '<option value="' + i + '">' + roofTileOptions.get(i) + '</option>';
        }

    }
    //need to fix: add makeCarport as a command
    //set roof materials on the request attributes.
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

//Variables connecting the JavaScript with the .jsp-page (the selects in the shed-div)
let lengthOptions = document.getElementById("shed-length");
let widthOptions = document.getElementById("shed-width");
let floorOptions = document.getElementById("shed-floor");
let wallOptions = document.getElementById("shed-wall");


function prepareShedMenu() {

    //Getting the given dimensions of the carport
    let carportLength = (document.getElementById("input-length").value)/10;
    let carportWidth = (document.getElementById("input-width").value)/10;

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
    fillDropDownShedFloor();
    fillDropDownShedWall();

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

    function fillDropDownShedFloor() {
        floorOptions.options[1] = new Option("Alm. planke", 55);
    }

    function fillDropDownShedWall() {
        wallOptions.options[1] = new Option("Eg", 50);
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
