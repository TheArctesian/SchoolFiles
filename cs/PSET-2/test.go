package main

import (
	"database/sql"
	"fmt"
	"log"
	"net/http"
)

func test(w http.ResponseWriter, req *http.Request) {

    fmt.Fprintf(w, "hello,\n this is my test page. \n \n Sincerely, \n Stephen Daniel Okita \n @theArctesian ")
}

func headers(w http.ResponseWriter, req *http.Request) {

    for name, headers := range req.Header {
        for _, h := range headers {
            fmt.Fprintf(w, "%v: %v\n", name, h)
        }
    }
}

func createUser(w http.ResponseWriter, r *http.Request) {
	if r.URL.Path != "/" {
		http.Error(w, "404 not found.", http.StatusNotFound)
		return
	}

	switch r.Method {
	case "GET":		
		http.ServeFile(w, r, "createUser.html")
	case "POST":
		// Call ParseForm() to parse the raw query and update r.PostForm and r.Form.
		if err := r.ParseForm(); err != nil {
			fmt.Fprintf(w, "ParseForm() err: %v", err)
			return
		}
		fmt.Fprintf(w, "Post from website! r.PostFrom = %v\n", r.PostForm)
		Username := r.FormValue("Username")
		Uid := r.FormValue("userID")
		year := r.FormValue("yearLevel")
		fmt.Fprintf(w, "Username = %s\n", Username)
		fmt.Fprintf(w, "UserId = %s\n", Uid)
		fmt.Fprintf(w, "Year = %s\n", year)
	default:
		fmt.Fprintf(w, "Sorry, only GET and POST methods are supported.")
	}
}
func main() {
	http.HandleFunc("/createUser", createUser)
    http.HandleFunc("/test", test)
    http.HandleFunc("/headers", headers)
	// http.Handle("/", http.FileServer(http.Dir("./static/front-end/public")))
	fmt.Printf("Starting server for testing HTTP POST...\n")
    if err := http.ListenAndServe(":8090", nil); err != nil {
		log.Fatal(err)
	}
	db, err := sql.Open("mysql",
		"user:password@tcp(127.0.0.1:3306)/hello")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()
}

//ya ive given up on this shit I am going back to node
// JK i havnt go is good enough