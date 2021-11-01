package main

import (
    "fmt"
    "net/http"
)

func hello(w http.ResponseWriter, req *http.Request) {

    fmt.Fprintf(w, "hello\n")
}

func headers(w http.ResponseWriter, req *http.Request) {

    for name, headers := range req.Header {
        for _, h := range headers {
            fmt.Fprintf(w, "%v: %v\n", name, h)
        }
    }
}

func penis(w http.ResponseWriter, req *http.Request){
	fmt.Fprintf(w, "penis in my ass")
}

func createUser(w http.ResponseWriter, req *http.Request){
	fmt.Fprintf(w, "fuck you" )
}

func main() {
    http.HandleFunc("/hello", hello)
    http.HandleFunc("/headers", headers)
	http.HandleFunc("/penis", penis)
	http.HandleFunc("/createUser", createUser)
	http.Handle("/", http.FileServer(http.Dir("./static/front-end/public")))
    http.ListenAndServe(":8090", nil)
}