<template>
<div>
  <div id="sideNav"></div>
  <div class="home">
   <div id="editDeckBtn"> Edit Deck </div> 
   <div id="editAddBtn"> Add Button </div>
    
    <h1 id="heading">Home</h1>
    <p id="heading_text">You must be authenticated to see this / Welcome Back --USER NAME HERE --</p>
      <div id="main_page">
        

          <div id="page_container">
            <div id="upper_row">
              <button type="submit" class="btnA">Add Card</button>
              <button type="submit" class="btnS">Sign in</button>
            </div>
            <div id="lower_row">
              <button type="submit" class="btn1">Saved Deck 1</button>
              <button type="submit" class="btn2">Saved Deck 2</button>
              <button type="submit" class="btn3">Saved Deck 2</button>
            
              
          </div>
          </div>
          
        </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>

#heading {
  justify-content: flex-end;
}

#editAddBtn {
  
}

#editDeckBtn {
  padding-left: 75%;
}

#sideNav {
  height: 100%;
  width: 20%;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  padding-top: 20px;
  padding-bottom: 20px;
  overflow-x: hidden;
  border-right: solid lightgrey 5px;
}

.home {
  height: 100%;
  width: 118%;
  position: fixed;
  
  left: 0;
  top: 0;
  padding-left: 20px;
  padding-top: 20px;
  padding-bottom: 20px;
  
}

#heading {
  text-align: center;
}

#heading_text {
  text-align: center;
}

#page_container {
  width: 500px;
    height: 500px;
    position: relative;
    margin: 10% auto;
    background: rgb(255, 255, 255);
    padding: 5px; 
    border-radius: 10px;
}

#upper_row {
  display: flex;
  margin: 11%;
  
}

#lower_row {
  display: flex;
  margin: 30% auto;
  
}

.btnA {
  cursor: pointer;
  height: 45px;
  margin: 50px;
  width: 35%;
  padding: 5px;
  display: block;
  margin: auto;
  border-radius: 20px;
  outline: none;
  background: linear-gradient(to right, #00ad00, #06cdff);
}

.btnS {
cursor: pointer;
    height: 45px;
    margin: 50px;
    width: 35%;
    padding: 5px;
    display: block;
    margin: auto;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #00ad00, #06cdff);
}

.btn1 {
  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 30%;
  padding: 5px;
  display: block;
  margin: auto;
  border-radius: 10px;
  outline: none;
  background: linear-gradient(to right, #abff10, #ffad06);
}

.btn2 {
  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 30%;
  padding: 5px;
  display: block;
  margin: auto;
  border-radius: 10px;
  outline: none;
  background: linear-gradient(to right, #abff10, #ffad06);
}

.btn3 {
  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 30%;
  padding: 5px;
  display: block;
  margin: auto;
  border-radius: 10px;
  outline: none;
  background: linear-gradient(to right, #abff10, #ffad06);
}
</style>
