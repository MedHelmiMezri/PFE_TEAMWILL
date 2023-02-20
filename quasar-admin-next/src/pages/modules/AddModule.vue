<template>
    <div>
      <div>
    <InputText v-model="text" />
  </div>
<Avatar label="P" />
<Avatar icon="pi pi-search" />
      <h2>Create New List:</h2>
      <form @submit.prevent="createList">
        <label>
          List Name:
          <input type="text" v-model="newListName">
        </label>
        <button type="submit">Create List</button>
      </form>
  
      <div v-if="lists.length">
        <h2>Lists:</h2>
        <ul>
          <li v-for="list in lists" :key="list.id">
            {{ list.name }}
            <button @click="deleteList(list)">Delete</button>
            <button @click="editList(list)">Edit</button>
            <ul>
              <li v-for="item in list.items" :key="item.id">
                {{ item.firstName }} {{ item.lastName }}
              </li>
            </ul>
            <form @submit.prevent="addItem(list)">
              <label>
                First Name:
                <input type="text" v-model="newItemFirstName">
              </label>
              <label>
                Last Name:
                <input type="text" v-model="newItemLastName">
              </label>
              <button type="submit">Add Item</button>
            </form>
          </li>
        </ul>
        <button @click="submitLists">Submit Lists</button>
      </div>
      

    </div>
  </template>
  
  <script>
  



  export default {
    data() {
      return {
        text: '' ,
        lists: [],
        newListName: '',
        newItemFirstName: '',
        newItemLastName: '',
        editListIndex: -1,
        editListItemIndex: -1,
      };
    },
    methods: {
      createList() {
        const newList = {
          id: Date.now(),
          name: this.newListName,
          items: [],
        };
        this.lists.push(newList);
        this.newListName = '';
      },
      deleteList(list) {
        const index = this.lists.indexOf(list);
        this.lists.splice(index, 1);
      },
      editList(list) {
        const index = this.lists.indexOf(list);
        this.newListName = list.name;
        this.editListIndex = index;
      },
      addItem(list) {
        const newItem = {
          id: Date.now(),
          firstName: this.newItemFirstName,
          lastName: this.newItemLastName,
        };
        list.items.push(newItem);
        this.newItemFirstName = '';
        this.newItemLastName = '';
      },
      submitLists() {
        // logic to submit all lists
      },
    },
    watch: {
      editListIndex(index) {
        if (index >= 0) {
          const list = this.lists[index];
          this.newListName = list.name;
        }
      },
      'lists[editListIndex].name'(name) {
        if (this.editListIndex >= 0) {
          this.lists[this.editListIndex].name = name;
        }
      },
    },
  };
  </script>
  