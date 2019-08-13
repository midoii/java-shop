<template>
  <div>
    <v-layout class="px-3 pb-2">
      <v-flex xs2>
        <v-btn color="info">新增品牌</v-btn>
      </v-flex>
      <v-spacer></v-spacer>
      <v-flex xs4>
        <v-text-field
          label="搜索" hide-details append-icon="search" v-model="key"
        ></v-text-field>
      </v-flex>
    </v-layout>


    <v-data-table
      :headers="headers"
      :items="brands"
      :pagination.sync="pagination"
      :total-items="totalBrands"
      :loading="loading"
      class="elevation-1"
    >
    <template slot="items" slot-scope="prop">
      <td class="text-xs-center">{{prop.item.id}}</td>
      <td class="text-xs-center">{{prop.item.name}}</td>
      <td class="text-xs-center"><img :src="prop.item.image" alt=""></td>
      <td class="text-xs-center">{{prop.item.letter}}</td>
      <td class="text-xs-center">
        <v-btn flat icon color="cyan">
          <v-icon>edit</v-icon>
        </v-btn>
        <v-btn flat icon color="cyan">
          <v-icon dark>delete</v-icon>
        </v-btn>
      </td>
    </template>
    </v-data-table>
  </div>
</template>

<script>
  export default{
    name:"MyBrand",
      data(){
        return{
          headers:[
              {text: '品牌id', align: 'center', sortable: true, value: 'id'},
              {text: '品牌名称', align: 'center', sortable: false, value: 'name'},
              {text: '品牌logo', align: 'center', sortable: false, value: 'image'},
              {text: '品牌首字母', align: 'center', sortable: true, value: 'letter'},
              {text: '操作', align: 'center', sortable: false},
          ],
            brands:[],
            totalBrands: 0,
            loading: false,
            pagination: {},
            key: "" //搜索条件
        }
      },
    created() {
        this.brands = [
            {id: 1, name: "雷布斯", image:"http://img13.360buyimg.com/popshop/jfs/t2458/318/1092287831/5774/b7b4ff89/563b3484N9ba68e13.jpg", letter: "X"}
        ];
        this.totalBrands = 15;
        this.loadBrands();
    },
      watch:{
        key(){
            this.pagination.page = 1;
        },
          pagination:{
              deep: true,
              handler(){
                this.loadBrands();
              }
          }
      },
    methods:{
      loadBrands(){
          this.loading = true;
        this.$http.get("/item/brand/page", {
            params:{
                page: this.pagination.page,
                rows: this.pagination.rowsPerPage,
                sortBy: this.pagination.sortBy,
                desc: this.pagination.descending,
                key: this.key,
            }
        }).then(resp => {
            this.brands = resp.data.items;
            this.totalBrands = resp.data.total;
            this.loading = false;
        })
      }
    }
  }
</script>

<style scoped>

</style>
