/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let len = document.getElementById("input-length").selected;
let wid = document.getElementById("input-width").selected;


document.getElementById("check-skur").addEventListener("click", checkShedMenuVisibility);
document.getElementById("check-skur").disabled = true;

//elements from OrderValidation.js
inputlength.addEventListener("change",function(){checkMenuState();});
inputwidth.addEventListener("change",function(){checkMenuState();});

function checkMenuState() {
    if (inputlength.selectedIndex == "0" || inputwidth.selectedIndex == "0")
    {
        document.getElementById("check-skur").disabled = true;
        document.getElementById("check-skur").checked = false;
        checkShedMenuVisibility();
    }
    else
    {
        document.getElementById("check-skur").disabled = false;
        clearShedMenu();
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
        let div = document.getElementById("carport-shed-form");
        div.removeAttribute("hidden");
        //Preparing the dropdowns with options for the shed
        prepareShedMenu();
    } 
    else
    {
        //Making the shed-form disappear
        let div = document.getElementById("carport-shed-form");
        div.setAttribute("hidden", "hidden");
        //Clearing the dropdowns for the shed
        clearShedMenu();
    }
}

//Variables connecting the JavaScript with the .jsp-page (the selects in the shed-form)
let lengthOptions = document.getElementById("shed-length");
let widthOptions = document.getElementById("shed-width");

function prepareShedMenu() {

    //Getting the given dimensions of the carport
    let carportLength = document.getElementById("input-length").value;
    let carportWidth = document.getElementById("input-width").value;

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
                //If the current values in the array "sValues" is -30 - that means
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
            lengthOptions.options[lengthOptions.options.length] = new Option(shedLength[i], i);
        }
        //This enhanced loop creates a new option in the select for the shed-dimensions
        for (j in shedWidth) {
            widthOptions.options[widthOptions.options.length] = new Option(shedWidth[j], j);
        }
    }
}

function clearShedMenu() {
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