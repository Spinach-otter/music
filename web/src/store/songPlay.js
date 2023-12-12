import $ from 'jquery'
import user from './user'

export default ({
    state: {
        songList: [],
        i: 0,//第几首歌
        music_name: "Music",
        music_src: "",
        music_photo: "",
        play_icon: "play_arrow",
        songPlaying: false,
    },
    mutations: {
        updateList(state, songList) {
            state.songList = songList;
        },
        // updateSongInfo(state, song) {
        //     state.music_name = song.songName;
        //     state.music_src = song.path;
        //     state.music_photo = song.photo;
        // },
        updatePlaying(state) {
            if (state.songPlaying) {
                state.songPlaying = true;
                state.play_icon = "pause";
            } else {
                state.songPlaying = false;
                state.play_icon = "play_arrow";
            }
        },
        updateSong(state, i) {
            state.i = i;
            state.music_name = state.songList[i].songName;
            state.music_src = state.songList[i].path;
            state.music_photo = state.songList[i].photo;
        },
    },
    actions: {
        getlist(context) {
            $.ajax({
                url: "http://localhost:8080/get/songlist/",
                type: "get",
                headers: {
                    Authorization: "Bearer " + user.state.token,
                },
                success(resp) {
                    context.commit("updateList", resp);
                    context.commit("updateSong", 0);
                    //data.success(resp);
                    // console.log(resp);
                },
            })
        },
        // getsong(context) {
        //     $.ajax({
        //         url: "http://localhost:8080/get/song/",
        //         type: "post",
        //         data: { i: context.state.i },
        //         headers: {
        //             Authorization: "Bearer " + user.state.token,
        //         },
        //         success(resp) {
        //             //context.commit("updateList", resp);
        //             //context.commit("updateSong", 0);
        //             //data.success(resp);
        //             context.commit("updateSongInfo", resp);
        //             console.log(resp);
        //         },
        //     })
        // },
        nextSong(context) {
            let x = context.state.i;
            x++;
            if (x > (context.state.songList.length - 1)) { x = 0; }
            context.commit("updateSong", x);
        },
        preSong(context) {
            let x = context.state.i;
            x--;
            if (x < 0) { x = (context.state.songList.length - 1); }
            context.commit("updateSong", x);
        },
    }
})