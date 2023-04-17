

    let thisPage = 1;
    let limit = 10;
    let list = document.querySelectorAll('.list .photoa');

    function loadItem(){
        let beginGet = limit * (thisPage - 1);
        let endGet = limit * thisPage - 1;
        list.forEach((photoa, key)=>{
            if(key >= beginGet && key <= endGet){
                photoa.style.display = 'block';
            }else{
                photoa.style.display = 'none';
            }
        })
        pagination();
    }
    loadItem();
    function pagination(){
        let count = Math.ceil(list.length / limit);
        document.querySelector('.pagination').innerHTML = '';

        if(thisPage != 1){
            let prev = document.createElement('li');
            let hr = document.createElement('a');
            hr.innerText = 'PREV';
            hr.setAttribute('onclick', "changePage(" + (thisPage - 1) + ")");
            document.querySelector('.pagination').appendChild(prev);
            prev.appendChild(hr);
        }

        for(i = 1; i <= count; i++){
            let newPage = document.createElement('li');
            let a = document.createElement('a');
            a.innerText = i;
            if(i == thisPage){
                a.classList.add('active');
            }
            a.setAttribute('onclick', "changePage(" + i + ")");
            document.querySelector('.pagination').appendChild(newPage);
            newPage.appendChild(a);
        }

        if(thisPage != count){
            let next = document.createElement('li');
            let a = document.createElement('a');
            a.innerText = 'NEXT';
            a.setAttribute('onclick', "changePage(" + (thisPage + 1) + ")");
            document.querySelector('.pagination').appendChild(next);
            next.appendChild(a);
        }
    }
    function changePage(i){
        thisPage = i;
        loadItem();
    }