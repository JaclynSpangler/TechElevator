<template>
<book-details />
  
</template>

<script>
import BookDetails from '@/components/BookDetails.vue'
export default {

    components: {
        BookDetails
    },
    created() {
    const activeIsbn = this.$route.params.isbn;
    this.$store.commit("SET_ACTIVE_BOOK", activeIsbn);
    },

}
</script>

<style>

</style>