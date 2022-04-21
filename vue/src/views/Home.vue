<template>

  <div id="content">
    <decks-list />
    
    



    <aside id="aside">
      <div class="study-sessions-text"> Study Sessions: </div>
      <div id="aside_buttons">

        <router-link v-for="decks in listOfDecks" v-bind:key="decks.deck_id" tag='button' v-bind:to="{ name: 'Study', params: {deckID:decks.deck_id} }" class="aside_btn1">{{ decks.deck_name }}</router-link>
          
      </div>
      
    </aside>



    <main id="main">
      <div id="container_box"> 
        
          <div id="main_buttons">
            <div id="upper_buttons">
              <router-link tag="button" type="submit" class="main_upper_btn" v-bind:to="{ name: 'Deck' }">Add Deck</router-link>
              <!-- <button type="submit" class="upper_btn2">Edit Deck</button> -->
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
import FlashService from '../services/FlashService';

export default {
  name: "home",
   data() {
     
    return {
      activeDeck: 1,
      listOfDecks: []
      }
    },
  views: { 
    AddFlashCard,
    EditCard,
    Deck},

    created(){
      FlashService.getDecks().then((response) => {
        this.listOfDecks = response.data;
      })
    }

};

</script>




<style scoped>

.study-sessions-text{
  color: antiquewhite;
  margin-top: 10px;
  font-size: 30px;
}

.home{
  display: flex;

}

#content {
  padding-top: 3%;
  
  display: grid;
  text-align: center;
  grid-template-columns: 20% auto;
  grid-template-rows: 90px 550px 60px;
  grid-gap: 10px;
  grid-template-areas: 
                       "aside aside main"
                       "aside aside main"
                       "aside aside main"
                       
}

#header {
border: 2px solid white;  
grid-area: header;
background: rgb(70, 70, 70);
border-radius: 15px;
width: 64%;
margin-left: 6%;


}

#header_buttons {
  display:flex;
  justify-content: center;
  margin-top: 8.5px;

}

.header_btn1 {
  display: grid;
  margin: 1% auto;
  margin-left: 19%;
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

.header_btn2 {
  display: grid;
  margin: 1% auto;
  margin-right: 19%;
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
  border: 2px solid white;
  grid-area: aside;
  overflow: hidden;
  background: rgb(70, 70, 70);
  border-radius: 15px;
  margin-left: 41%;
  
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
  height: 80px;
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
  height: 80px;
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
  height: 80px;
  width: 90%;
  padding: 5px;
  display: block; 
  border-radius: 10px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
    
}

#main {
  
  grid-area: main;
  margin-left: -11%;
  margin-right: 12%;
}


#container_box{
  display: grid;
  grid-template-rows: 1fr 1fr;
  border: 2px solid white;
  margin: auto;
  margin-top: 2px;
  width: 65.5%;
  height: 97%;
  background: rgb(70, 70, 70);
  border-radius: 15px;
  
}

#upper_buttons {
  margin: auto;
  display: flex;
  grid-template-rows: 10px;
  justify-content: space-around;
  
}

.main_upper_btn {
  cursor: pointer;
    height: 450px;
    margin-left: 100px;
    margin-top: 17%;
    width: 50%;
    padding: 100px;
    display: block;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #b1ff20, #ff9f05);
    font-family: 'Nunito Sans';
    font-size: 30px;  
    display: flex;
    margin-right: 12%;
}  
    

.upper_btn2 {
  cursor: pointer;
    height: 310px;
    margin-right: 100px;
        margin-top: 17%;
    width: 30%;
    padding: 100px;
    display: block;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #b1ff20, #ff9f05);
    font-family: 'Nunito San';
    font-size: 30px;
    
}


</style>
