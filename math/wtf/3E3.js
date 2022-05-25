var goals = [0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3,
    3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 9, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3,
    3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8
];
var girls = [0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3,
    3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 9
];
var boys = [0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3,
    3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8
]

var total = 0;
var girlSample = [];
var boysSample = [];
sample = [];
//avg of goals 
for (var i = 0; i < 12; i++) {
    total += girls[i];
    sample.push(girlSample[i]);
}

for (var i = 0; i < 12; i++) {
    total += boys[i];
    sample.push(boysSample[i]);
}
console.log(total / goals.length);