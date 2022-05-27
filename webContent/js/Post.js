//categories buttons
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function myFunction2() {
    document.getElementById("myDropdown2").classList.toggle("show");
}

function myFunction3() {
    document.getElementById("myDropdown3").classList.toggle("show");
}

function myFunction4() {
    document.getElementById("myDropdown4").classList.toggle("show");
}

function myFunction5() {
    document.getElementById("myDropdown5").classList.toggle("show");
}

function myFunction6() {
    document.getElementById("myDropdown6").classList.toggle("show");
}
// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.btns')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

/*********** */
// Function to show or hide div based on which radio is selected
function showDiv() {
    [].forEach.call(document.querySelectorAll('[name=divToggle]'), function(button) {
        document.getElementById(button.dataset.divid).className = button.checked ? '' : 'hidden';
    })
}

// Attach click listeners onload
window.onload = function() {
    [].forEach.call(document.querySelectorAll('[name=divToggle]'), function(button) {
        button.onclick = showDiv;
    })
}

// new
var getValueOfRadioGroup = (name) => {
	let radioButtons = document.querySelectorAll(`input[name=${name}]`);
	let value = "there is no checked";
    for (const radioButton of radioButtons) {
        if (radioButton.checked) {
            value = radioButton.value;
            break;
        }
    }
    return value;
};
var hideAllSubCategories = () => {
	let subs = document.querySelectorAll('.sub-categories-section');
	for(const element of subs) {
		element.setAttribute('style', "display: none");
	}
};
var openSubCategories = () => {
	hideAllSubCategories();
	let target = getValueOfRadioGroup("main");
	let sub = document.getElementById(target);
	sub.setAttribute("style", "");
};
var setListenerToMainCategories = () => {
	hideAllSubCategories();
	let mains = document.querySelectorAll('.main-category');
	for(const element of mains) {
		element.addEventListener('click', openSubCategories);
	}
};
var submitButton = document.getElementById("AddPostButton");
var fileInput = document.getElementById("image");
var form = document.getElementById("addPostForm");

var imageInput = null;
var contentInput = document.getElementById("content");
var priceTypeInput = null;
var priceValueInput = document.getElementById("priceValue");
var emailInput = document.getElementById("email");
var phoneNumberInput = document.getElementById("phoneNumber");


var askToSelectImage = () => {
	showAlert("please select image first !!");
};
var addPost = () => {
	submitButton.removeEventListener("click", addPost);
	let price = null;
	priceTypeInput = getValueOfRadioGroup("price");
	if(priceTypeInput == "Free") {
		price = 0;
	} else if(priceTypeInput == "Price") {
		price = priceTypeInput.value;
	}
	let image = imageInput.value;
	let content = contentInput.value;
	let email = emailInput.value;
	let phoneNumber = phoneNumberInput.value;
	let subCategory = getValueOfRadioGroup("sub");
	if(content == "") {
		showAlert("please enter content for your post");
		submitButton.addEventListener("click", addPost);
		return;
	}
	if(subCategory == "there is no checked") {
		showAlert("please select sub and main categories");
		submitButton.addEventListener("click", addPost);
		return;
	}
	let data = {
		"content": content,
		"image": image,
		"content": content,
		"email": email,
		"phoneNumber": phoneNumber,
		"subCategory": subCategory
	};
	if(price != null) {
		data.price = price;
	}
	fetch(AddPostUrl, {
		method: 'POST',
		body: JSON.stringify(data)
	}).then(response => response.json()).then(data => {
		showAlert(data.msg);
	}).catch((msg) => {
		showAlert(msg);
	});
	submitButton.addEventListener("click", addPost);
};
var getBase64 = (file) => {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => resolve(reader.result);
    reader.onerror = error => reject(error);
  });
};
submitButton.addEventListener("click", askToSelectImage);
fileInput.onchange = () => {
	let file = fileInput.files[0];
	getBase64(file).then(data => {
		imageInput = document.createElement("input");
		imageInput.setAttribute("name", "image");
		imageInput.setAttribute("type", "text");
		imageInput.setAttribute("value", data);
		imageInput.setAttribute("style", "display: none;");
		form.appendChild(imageInput);
		submitButton.removeEventListener("click", askToSelectImage);
		submitButton.addEventListener("click", addPost);
	});
};

setListenerToMainCategories();
