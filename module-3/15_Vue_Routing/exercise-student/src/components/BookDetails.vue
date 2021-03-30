<template>
    <div>
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <p>I have {{book.read ? "read" : "not read" }} this book</p>
    </div>
</template>

<script>
export default {
     computed: {
        book(){
            return this.$store.state.books.find(
                b => b.isbn == this.$store.state.activeBook
            );

}
}
}
</script>

<style>

</style>