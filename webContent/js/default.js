var popUpMassageDiv = document.getElementById('popUpMassageDiv');
var defaultStyleOfPopUpMassegeInWeb = {'headerBackgroundColor': '#3499b8', 'buttonBackgroundColor': '#3499b8', 'buttonColor': '#fff'};
function showAlert(msg, exitButtonListener = null, okButtonListener = null) {
	showPopUpMassage(msg, exitButtonListener, okButtonListener, 'ok', defaultStyleOfPopUpMassegeInWeb);
}
function showPopUpMassage(content,exitButtonListener = null,okButtonListener = null, buttonContent = 'ok',data = null) {
    if(popUpMassageDiv == null) {
        popUpMassageDiv = createAndReturnPopUpMassageDiv();
        if(popUpMassageDiv == null) return;
    }
    if(popUpMassageDiv.children.length > 0) {
        if(popUpMassageDiv.children[0].children.length > 2) {
            popUpMassageDiv.children[0].children[1].textContent = content;
            var exitThis = function (popUpMassageDiv) {
                popUpMassageDiv.setAttribute('style','display:none !important;');
                popUpMassageDiv.style = 'display:none !important;';
            };
            var exitButtonListenerDefault = function (){
                exitThis(popUpMassageDiv);
            };
            var okButtonListenerDefault = function() {
                exitThis(popUpMassageDiv);
            };
            if(exitButtonListener != null) {
                exitButtonListenerDefault = function() {
                    exitButtonListener(exitThis,popUpMassageDiv,data);
                };
            }
            if(okButtonListener != null) {
                okButtonListenerDefault = function() {
                    okButtonListener(exitThis,popUpMassageDiv,data);
                };
            }
            if(popUpMassageDiv.children[0].children[0].children.length > 0) {
                popUpMassageDiv.children[0].children[0].children[0].onclick = exitButtonListenerDefault;
            }
            if(popUpMassageDiv.children[0].children[2].children.length > 0) {
                popUpMassageDiv.children[0].children[2].children[0].textContent = buttonContent;
                popUpMassageDiv.children[0].children[2].children[0].onclick = okButtonListenerDefault;
            }
            if(data != null) {
                if(typeof(data) == "object") {
                    try {
                        if(data.hasOwnProperty("headerBackgroundColor")) {
                            popUpMassageDiv.children[0].children[0].setAttribute('style', 'background-color: ' + data.headerBackgroundColor + ';');
                        }
                        if(data.hasOwnProperty("buttonBackgroundColor")) {
                            popUpMassageDiv.children[0].children[2].children[0].setAttribute('style', (popUpMassageDiv.children[0].children[2].children[0].getAttribute('style') == null || popUpMassageDiv.children[0].children[2].children[0].getAttribute('style') == undefined ? '' : popUpMassageDiv.children[0].children[2].children[0].getAttribute('style')) + 'background-color: ' + data.buttonBackgroundColor + ';');
                        }
                        if(data.hasOwnProperty("buttonColor")) {
                            popUpMassageDiv.children[0].children[2].children[0].setAttribute('style', (popUpMassageDiv.children[0].children[2].children[0].getAttribute('style') == null || popUpMassageDiv.children[0].children[2].children[0].getAttribute('style') == undefined ? '' : popUpMassageDiv.children[0].children[2].children[0].getAttribute('style')) + 'color: ' + data.buttonColor + ';');
                        }
                    } catch(ex) { }
                }
            }
            popUpMassageDiv.setAttribute('style','');
            popUpMassageDiv.style = '';
        }
    }
}
function createAndReturnPopUpMassageDiv() {
    "use strict"
    var ParentDiv = document.createElement('div');
    var ChildDiv = document.createElement('div');
    ParentDiv.setAttribute('id','popUpMassageDiv');
    ParentDiv.setAttribute('class','default-pop-up-ok-massege no-select');
    ParentDiv.setAttribute('style','display:none !important;');
    ParentDiv.style = 'display:none !important;';

    var header = document.createElement('header');
    var section = document.createElement('section');
    var footer = document.createElement('footer');
    var exitThis = function () {
        ParentDiv.setAttribute('style','display:none !important;');
        ParentDiv.style = 'display:none !important;';
    };

    var headerExitButton = document.createElement('div');
    var canvas = makeRemoveIconCanvas('#ffffff');
    headerExitButton.appendChild(canvas);
    headerExitButton.onclick = exitThis;
    header.appendChild(headerExitButton);

    var footerExitButton = document.createElement('button');
    footerExitButton.textContent = 'OK';
    footerExitButton.onclick = exitThis;
    footer.appendChild(footerExitButton);

    ChildDiv.appendChild(header);
    ChildDiv.appendChild(section);
    ChildDiv.appendChild(footer);

    ParentDiv.appendChild(ChildDiv);
    if(document.body.children.length > 0) document.body.insertBefore(ParentDiv,document.body.children[0]);
    else document.body.appendChild(ParentDiv);
    return ParentDiv;
}
function makeRemoveIconCanvas(color) {
    "use strict"
    var canvas = document.createElement('canvas');
    canvas.width = 20;
    canvas.height = 20;
    drawRemoveIconCanvas(canvas,color);
    return canvas;
}
function drawRemoveIconCanvas(canvas,color) {
    "use strict"
    if(canvas != null) {
        var padding = canvas.width/8;
        var w = canvas.width-2*padding, h = canvas.height-2*padding;
        var context = canvas.getContext('2d');
        context.strokeStyle = color;
        context.lineWidth = 3;
        context.beginPath();
        context.moveTo(padding,padding);
        context.lineTo(w,h);
        context.moveTo(w,padding);
        context.lineTo(padding,h);
        context.stroke();
    }
}