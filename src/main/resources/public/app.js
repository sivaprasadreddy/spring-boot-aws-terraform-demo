new Vue({
    el: '#app',
    data: {
        randomJoke: {
            body: "If you can't see a Joke here then this application is a joke"
        }
    },
    created: function () {
        this.fetchRandomJoke();
    },
    methods: {
        fetchRandomJoke() {
            let self = this;
            $.getJSON("api/jokes/random", function (data) {
                self.randomJoke = data
            });
        },
    }
});
