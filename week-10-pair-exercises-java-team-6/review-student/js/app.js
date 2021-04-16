const problems = [];
let correctAnswer;
let score;
let problemNumber;


function generateNewProblems(){
score = 0;
problemNumber = 1;
for(let i = 0; i <10; i++){
    let leftNumber= getRandomNumber(10);
    let rightNumber= getRandomNumber(10);
    let thisAnswer= leftNumber * rightNumber;
    
    problems.push({
        equation: leftNumber + ' * ' + rightNumber,
        answer: thisAnswer
    }) 
}
 shuffleArray(problems);

 displayStats();

 displayCurrentProblem();

}

function generateChoices(problem){
    let choices = [];
    choices.push(problem.answer);
    
    while(choices.length < 4){
    let newChoice = getRandomNumber(82);
    if(!choices.includes(newChoice)){
        choices.push(newChoice)
}}

choices = shuffleArray(choices);

const choiceList= document.querySelectorAll('section#answers ul li');
 for(let i = 0; i < choiceList.length; i++){
    choiceList[i].innerText = choices[i];
    }

}
function displayCurrentProblem(){
    const expression= document.querySelector('.expression');
    expression.innerText =  problems[problemNumber-1].equation;
    correctAnswer= problems[problemNumber-1].answer;

    generateChoices(problems[problemNumber-1]);
}

function displayStats(){
    const currentProblemDisplay = document.querySelector('span.currentProblem');
    currentProblemDisplay.innerText= problemNumber;
    const currentScoreDisplay = document.querySelector('span.currentScore');
    currentScoreDisplay.innerText= score;
} 

function getRandomNumber(max) {
  return Math.floor(Math.random() * Math.floor(max));
}

function shuffleArray(array){
    return array.sort(function (a, b) { return Math.random() - 0.5 })
}


document.addEventListener('DOMContentLoaded', () => {
    generateNewProblems();

    
    
    const choiceList= document.querySelector('section#answers ul');
    choiceList.addEventListener('click', (event)=>{
        if(event.target.innerText == correctAnswer){
            score++;
        }
        if(problemNumber < 10){
        problemNumber++;
        displayCurrentProblem();
        
        }else{
            const showHide= document.querySelectorAll('.show-hide');
            showHide.forEach((element) => {
                element.classList.add('hidden');
            })
        }
        displayStats();

    })

    const startOver = document.getElementById('btnStartOver');
    startOver.addEventListener('click', (event) => {
        generateNewProblems();
        const showHide= document.querySelectorAll('.show-hide');
        showHide.forEach((element) => {
            element.classList.remove('hidden');
    });})
    

})