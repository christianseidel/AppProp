import React, {useState, useEffect, FormEvent} from 'react';
import "./styles.css"

function App() {

    const [greeting, setGreeting] = useState('');
    const [item, setItem] = useState('');
    const [answer, setAnswer] = useState<string[]>(['nothing yet...', '']);


    useEffect(() => {
        getGreeting()
    }, []);

    const getGreeting = () => {
        fetch('/api/greeting', {
            method: 'GET',
            headers: {
                'Accept': 'text/plain'
            }
        })
            .then(response => response.text())
            .then(text => setGreeting(text))
            .catch(err => setGreeting('Da ist etwas schief gelaufen'));
    }

    const sendItem = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        fetch('api/item/' + item, {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            }
        })
                .then(response => response.json())
                .then((response: string[]) => {
                    setAnswer(response);
                    setItem('')
                })
                .catch(err => setAnswer(['Da ist etwas schief gelaufen', '']));
    }

    return (
        <div>
            <p>okay, this is my</p>
            <h1>Test App</h1>
            <p>And this is content delivered by the Server:</p>
            <br/>
            <span className={'showLarge'}>{greeting}!</span>
            <br/><br/><br/>
            <div className={'showLarge'}></div>
            <button id={'getNext'} onClick={getGreeting} type={'button'}>get next!</button>
            <br/><br/><br/>

            <form onSubmit={ev => sendItem(ev)}>
            <input type={'text'} value={item} placeholder={'just enter something'} autoFocus required
            onChange={ev => setItem(ev.target.value)}></input>
                <span>
                    <button id={'sendItem'} type={'submit'}>send</button>
                </span>
            </form>
            <br/><br/><br/>
            <div className={'show'}><span className={'introduction'}>{answer[0]}</span> <span className={'answer'}>{answer[1]}</span></div>
        </div>
    );
}

export default App;
