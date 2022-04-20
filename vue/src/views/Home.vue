<template>

  <div id="content">
    <decks-list />
    
    <header id="header">
      <div id="header_buttons">
        <!-- <router-link tag="button" type="submit" class="header_btn" v-bind:to="{ name: 'AddFlashCard', params: { deckID: activeDeck } }">Add Card</router-link>
        <router-link tag="button" type="submit" class="header_btn" v-bind:to="{ name: 'EditCard' }">Edit Card</router-link> -->
      </div>
    </header>



    <aside id="aside">
      <div id="aside_buttons">
        <router-link tag='button' v-bind:to="{ name: 'Study', params: {deckID: 1} }" class="aside_btn1">Deck 1</router-link>
        <router-link tag='button' v-bind:to="{ name: 'Study', params: {deckID: 2} }" class="aside_btn1">Deck 2</router-link>
        <router-link tag='button' v-bind:to="{ name: 'Study', params: {deckID: 3} }" class="aside_btn1">Deck 3</router-link>
          
      </div>
      
    </aside>



    <main id="main">
      <div id="container_box"> 
        
          <div id="main_buttons">
            <div id="upper_buttons">
              <router-link tag="button" type="submit" class="main_upper_btn" v-bind:to="{ name: 'Deck' }">Add Deck</router-link>
              <button type="submit" class="upper_btn2">Edit Deck</button>
            </div>
          </div>
        
      </div>
    </main>



    <footer id="footer">

    </footer>

  </div>
</template>



<script>
import AddFlashCard from '@/views/AddFlashCard'
import EditCard from '@/views/EditCard'
import Deck from '@/views/Deck'

export default {
  name: "home",
   data() {
    return {
      activeDeck: 1,
      }
    },
  views: { 
    AddFlashCard,
    EditCard,
    Deck}
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
border: 3px solid cyan;  
grid-area: header;
background: brown;


}

#header_buttons {
display:flex;
justify-content: center;

}

.header_btn {
  display: grid;
  margin: 1% auto;
  grid-template-rows: 20px;
  background: linear-gradient(to right, #b1ff20, #ff9f05);

  cursor: pointer;
  height: 55px;
  width: 25%;
  padding: 5px;
  display: block;
  border-radius: 20px;
  outline: none;
  font-family: 'Nunito Sans';
  font-size: 30px;
    
}

#aside {
  border: 3px solid cyan;
  grid-area: aside;
  overflow: hidden;
  background: brown;
  
}

#aside_buttons {
  margin-top: auto;
  
}

.aside_btn1{
  display: grid;
  grid-template-rows: 40px;
  margin: 20px;

  font-family: 'Nunito Sans';
  font-size: 30px;
  cursor: pointer;
  height: 100px;
  width: 90%;
  padding: 5px;
  display: block;
  border-radius: 10px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
    
}

.aside_btn2{
  display: grid;
  grid-template-rows: 40px;
  margin: 20px;

  font-family: 'Nunito Sans';
  font-size: 30px;
  cursor: pointer;
  height: 100px;
  width: 90%;
  padding: 5px;
  display: block;
  border-radius: 10px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
    
}

.aside_btn3{
  display: grid;
  grid-template-rows: 40px;
  margin: 20px;

  font-family: 'Nunito Sans';
  font-size: 30px;
  cursor: pointer;
  height: 100px;
  width: 90%;
  padding: 5px;
  display: block; 
  border-radius: 10px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
    
}

#main {
  border: 3px solid cyan;
  grid-area: main;
}

#container_box{
  display: grid;
  grid-template-rows: 1fr 1fr;
  border: 2px solid cyan;
  margin: auto;
  margin-top: 2px;
  width: 99.5%;
  height: 98%;
  background: #39FF14;
  
}

#upper_buttons {
  margin: auto;
  display: flex;
  grid-template-rows: 10px;
  justify-content: space-around;
  
}

.main_upper_btn {
  cursor: pointer;
    height: 110px;
    margin: 50px;
    width: 25%;
    padding: 5px;
    display: block;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #b1ff20, #ff9f05);
    font-family: 'Nunito Sans';
    font-size: 30px;    
    
}
.upper_btn2 {
  cursor: pointer;
    height: 110px;
    margin: 50px;
    width: 25%;
    padding: 5px;
    display: block;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #b1ff20, #ff9f05);
    font-family: 'Nunito San';
    font-size: 30px;
    
}


</style>
