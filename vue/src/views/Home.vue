<template>

  <div id="content">
    <decks-list />
    
    <header id="header">HEADER
      <router-link tag="button" type="submit" class="header_btn" v-bind:to="{ name: 'AddFlashCard' }">Add Card</router-link>
      <router-link tag="button" type="submit" class="header_btn" v-bind:to="{ name: 'EditCard' }">Edit Card</router-link>
  
    </header>



    <aside id="aside">ASIDE
      <button type="submit" class="aside_btn">Easy Difficulty</button>
      <button type="submit" class="aside_btn">Medium Difficulty</button>
      <button type="submit" class="aside_btn">Hard Difficulty</button>
    
      
    </aside>



    <main id="main"> MAIN
      <div id="container_box">
        <button type="submit" class="main_upper_btn">Add Deck</button>
        <button type="submit" class="main_upper_btn">Edit Deck</button>
        <button type="submit" class="main_lower_btn">Deck 1</button>
        <button type="submit" class="main_lower_btn">Deck 2</button>
        <button type="submit" class="main_lower_btn">Deck 3</button>

        
      </div>
    </main>



    <footer id="footer">FOOTER

    </footer>

  </div>
</template>



<script>
import AddFlashCard from '@/views/AddFlashCard'
import EditCard from '@/views/EditCard'
import DecksList from '@/components/DecksList'

export default {
  name: "home",
  components: {DecksList},
  views: {AddFlashCard, EditCard}
};
</script>




<style scoped>

#content {
  display: grid;
  text-align: center;
  grid-template-columns: 20% auto;
  grid-template-rows: 90px 500px 60px;
  grid-gap: 10px;
  grid-template-areas: "aside header"
                       "aside main"
                       "footer footer";
}

#header {
border: 3px solid;  
grid-area: header;

}

.header_btn {
  display: grid;
  margin: auto;
  grid-template-rows: 20px;
  

}

#aside {
  border: 3px solid;
  grid-area: aside;
  
}

.aside_btn{
display: grid;
grid-template-rows: 20px;
margin: auto;


}

#main {
  border: 3px solid;
  grid-area: main;
}

#container_box{
  display: grid;
  grid-template-rows: 1fr 1fr;
  border: 2px solid;
  margin: auto;
  margin-top: 5px;
  width: 600px;
  height: 400px;
}

.main_upper_btn {
  display: grid;
  margin: auto;
  grid-template-rows: 20px;
}

.main_lower_btn {
  display: grid;
  margin: auto;
  grid-template-rows: 20px;
}

#footer {
border: 3px solid;  
grid-area: footer;
}

</style>
