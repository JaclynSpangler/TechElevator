function demoPreviousElementSibling(){
    const buttonOne= document.getElementById('button-one');
    const prevElementSibling = buttonOne.previousElementSibling;
    prevElementSibling.innerText= 'Previous element sibling to button 1';
    const nextElementSib = buttonOne.nextElementSibling;
    nextElementSib.innerText='Next element sibling to button 1';
}

function makeBackgroundGreen(currentTarget, target){
    currentTarget.classList.add('greenbackground');
    alert('You originally clicked on'+ target.innerText);
}

function forbidden(event){
    alert('you must stay on this page');
    event.preventDefault();
}


function checkTheCheckBoxAndEnterText(event){
    const cb = document.querySelector('div input');
    cb.checked= true;
    cb.nextElementSibling.value= event.target.innerText;
    event.stopPropagation();
}

const pushMeButton= document.getElementById('button-one');
pushMeButton.addEventListener('click', checkTheCheckBoxAndEnterText);

const dontPushMe= document.getElementById('button-two');
dontPushMe.addEventListener('click', (event) => event.target.setAttribute('class', 'makeTextYellow'));

const buttonDiv= document.getElementById('buttons');
buttonDiv.addEventListener('click',(event) => makeBackgroundGreen(event.currentTarget));

document.querySelectorAll('a').forEach(element => element.addEventListener('click', forbidden));