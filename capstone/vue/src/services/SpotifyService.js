import axios from 'axios';
import qs from 'qs'

export default {



  token: "BQCrACx9eagglH9JbbzZNh7lmS5Mou5EM9XI7Wi7AOr3Ic_3vfRliuBw8cQsD0_VQNgdH5NjJmAnX8UzWgL2RXia0S8njij7fTZNL5w5hCqq8KtQWhWL_v_ReRSXvQHIZshvlolzjTM93xgmHan8sb3J3CCPTtHkT7Ofy4971KJQfEvlYp5Eep3Nib9TQZqAHIbJN9c_mtUYCitv",
  refreshtoken: "AQDTflXhnThr5muM07RdlanRs8kwD_pZX1migRPAR6hjwKhDQC5FrOpxl5lzhrpwem4J7IfvwP-BNzfULgTcZtK8aosRlallD0uzC9pGGSCoK3wR2Aofdkh38Y61cp1XBPY",

  async authorize() {
    const data = {
      response_type: 'code',
      client_id: '6a349475303f406d83af30cd90999cb7',
      redirect_uri: 'http://localhost:8080/callback',
      scope: [
        'user-read-playback-state',
        'user-modify-playback-state',
        'user-read-currently-playing',
        'streaming',
        'app-remote-control',
        'playlist-read-collaborative',
        'playlist-modify-public',
        'playlist-read-private',
        'playlist-modify-private',
        'user-library-modify',
        'user-library-read',
        'user-top-read',
        'user-read-playback-position',
        'user-read-recently-played',

      ].join(",")
    },
      headers = {

        Accept: 'application/json',
        Content_Type: 'application/x-www-form-urlencoded',
      }
    try {
      const response = await axios.get('https://accounts.spotify.com/authorize?client_id=6a349475303f406d83af30cd90999cb7&redirect_uri=http://localhost:8080/&response_type=code&scope=user-modify-playback-state+user-read-currently-playing',
        data,
        headers
      )
       console.log(response)
// console.log(window.location(this.redirectURI))
// console.log(URL(response))
    }
    catch (error) {
      console.log(error);
    }
  },
  async getAuth() {
    const clientId = '6a349475303f406d83af30cd90999cb7';
    const clientSecret = 'f7d10946eb1540a08a6fcbb3d8f450d8';
    const redirectURI = 'http://localhost:8080/'
    alert("I'm in get auth")

    const headers = {
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      auth: {
        username: clientId,
        password: clientSecret,
      },
    };
    const data = {
      grant_type: 'authorization_code',
      redirect_uri: redirectURI,
      code: "AQDjRnFRYoyg3oldpO53JiWUXMPsxhCvO4N-JDDOHJ3NcCifs4MKRUoAzbWQKzPw5u84aB4e8272UsN5-pWD4pk7gQirUPzcY1gFVG58WPxVq7bCGlS554N8lwETiz2WR4h1ozspfwXOPs8_GKvsKgZUGYoOw0SoW67wzPtzea-AtaZmSykxk6F3e1EE2xfYQ9ccwr__-IKw2pF0BggJ1xa28zKGXwFPa7kd5WI_PnNHmeI",

    };
    try {
      const response = await axios.post(
        'https://accounts.spotify.com/api/token',
        qs.stringify(data),
        headers
      );
      console.log(response.data.access_token);
      this.token = response.data.access_token
      this.refreshtoken = response.data.refresh_token
      return response.data.access_token;

    } catch (error) {
      console.log(error);
    }

  },


  // DA HTTP REQUESTS!!

  async getSong() {

    try {
      const response = await axios.get('https://api.spotify.com/v1/tracks/2ncLdwTd8qzkxiJjlbiOgC', {
        headers: {

          Authorization: "Bearer " + this.token,
        }

      })

      console.log(response);

    }
    catch (error) {
      console.log(error);
    }

  },
  playSong(uri) {
    alert('PLAYING')
    try {
      let body = {
        device_id: "e055bbef918baf953f059e8ea3ad67a62aea07f5",
        uris: [uri]
        }
      axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
      const response = axios.put('https://api.spotify.com/v1/me/player/play', body)


      console.log(response);

    }
    catch (error) {
      console.log(error);
    }
  },

  queueSong(uri) {
    alert('PLAYING')
    try {
      let body = {
        uri: uri
        }
      axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
      const response = axios.post('https://api.spotify.com/v1/me/player/queue?uri='+ uri, body)


      console.log(response);
      alert("Added")

    }
    catch (error) {
      console.log(error);
    }
  },

   async nextSong(){
      try {
        let body = {
          device_id: "e055bbef918baf953f059e8ea3ad67a62aea07f5",
          }
         axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
        const response = await axios.post('https://api.spotify.com/v1/me/player/next', body)
  
  
        console.log(response);
        this.currentSong()
      }
      catch (error) {
        console.log(error);
      }
  },
  async currentSong(){
    try {
      let body = {
        device_id: "e055bbef918baf953f059e8ea3ad67a62aea07f5",
        }
      axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
      const response = await axios.get('https://api.spotify.com/v1/me/player/currently-playing', body)


      alert(response.data.item.name +
        ' by ' + response.data.item.artists[0].name
        );
      // alert(
      //   response.data.item.artists[0].name,
      //   response.data.item.name

      //   )
console.log(response)
    }
    catch (error) {
      console.log(error);
    }
},
  async searchSong(search) {

    try {
      const response = await axios.get(`https://api.spotify.com/v1/search?q=${search}&type=track,artist`, {
        headers: {

          Authorization: "Bearer " + this.token
        }

      })
      // for(let i = 0; i < 10; i++){
        return(response)
          // response.data.tracks.items[i].album.artists[0].name,
          // response.data.tracks.items[i].name,
          // response.data.tracks.items[i].uri,
          // response.data.tracks.items[i].album.name
          // )
        }
    // }
    catch (error) {
      console.log(error);
    }

  },


}