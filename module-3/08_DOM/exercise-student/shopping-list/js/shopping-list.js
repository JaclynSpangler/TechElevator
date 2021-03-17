// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
const groceries = ['Bread', 'Pizza Dough', 'Crunchy Peanut Butter', 'Paper Towels', 'Marinara',
                  'Dairy-Free Cheese', 'Mozzarella', 'Capicola', 'Dairy-Free Butter', 'Basil']

/**
 * <div class="shopping-list">
        <h1 id="title"></h1>
        <ul id="groceries">
            <!-- add groceries here -->
        </ul>
    </div>
 * 
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
 const title = document.getElementById('title');
 title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const showGroceries = document.querySelector('#groceries');
  for(let i = 0; i <groceries.length; i++){
    const item = document.createElement('li');
    item.innerText = groceries[i];
    showGroceries.insertAdjacentElement('beforeend', item);
  }

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const checkList = document.querySelectorAll('#groceries li');
  checkList.forEach(element => element.setAttribute('class', 'completed')
  );
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
