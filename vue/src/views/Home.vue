<template>

  <div id="content">
    <decks-list />
    
    <header id="header">HEADER
      <div id="header_buttons">
        <router-link tag="button" type="submit" class="header_btn" v-bind:to="{ name: 'AddFlashCard' }">Add Card</router-link>
        <router-link tag="button" type="submit" class="header_btn" v-bind:to="{ name: 'EditCard' }">Edit Card</router-link>
      </div>
    </header>



    <aside id="aside">ASIDE
      <div id="aside_buttons">
        <button type="submit" class="aside_btn1">Easy Difficulty</button>
        <button type="submit" class="aside_btn2">Medium Difficulty</button>
        <button type="submit" class="aside_btn3">Hard Difficulty</button>
        
        
      </div>
      
    </aside>



    <main id="main"> MAIN
      <div id="container_box">
        <div id="main_buttons">
          <div id="upper_buttons">
            <button type="submit" class="upper_btn1">Add Deck</button>
            <button type="submit" class="upper_btn2">Edit Deck</button>
          </div>
          <div id="lower_buttons"> 
            <button type="submit" class="lower_btn1">Deck 1</button>
            <button type="submit" class="lower_btn2">Deck 2</button>
            <button type="submit" class="lower_btn3">Deck 3</button>
            
          </div> 
        </div>
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

#header_buttons {
display:flex;
justify-content: center;
}

.header_btn {
  display: grid;
  margin: auto;
  grid-template-rows: 20px;
}

#aside {
  border: 3px solid;
  grid-area: aside;
  overflow: hidden;
}

#aside_buttons {
  margin: 20px;
  display: flex;
  flex-direction: column;
  justify-content: end;
}

.aside_btn1{
  display: grid;
  grid-template-rows: 40px;
  margin: 28px;
}

.aside_btn2{
  display: grid;
  grid-template-rows: 40px;
  margin: 28px;
}

.aside_btn3{
  display: grid;
  grid-template-rows: 40px;
  margin: 28px;
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

#upper_buttons {
  margin: 20px;
  display: flex;
  grid-template-rows: 20px;
  display: flex;
  justify-content: space-around;
}

#lower_buttons {
  margin: 20px;
  display: flex;
  grid-template-rows: 20px;
  display: flex;
  justify-content: space-around;
}

#footer {
border: 3px solid;  
grid-area: footer;
}

</style>
