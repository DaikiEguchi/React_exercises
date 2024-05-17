import React, { useState, useEffect } from 'react';

function Apartment() {
    const [data, setData] = useState();

    useEffect(() => {
        console.log("call useEffect START");
        fetch('http://localhost:8080/apartment').then(response => {
            response.json().then(value => {
                console.log(value);
                setData(value);
            })
        })
            .catch(error => {
                console.log(error);
                setData([]);
            });

        console.log("call useEffect END");
        return () => { };
    }, []);

    const apartmentData = data && data.map((item, index) => {
        return (
            <tr key={index}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.address}</td>
                <td>{item.sales}</td>
                <td>{item.floorArea}</td>
                <td><button type='submit' onClick={() => deleteData(item)}>削除</button></td>
            </tr>);
    })

    // 在庫情報を追加する関数
    const addData = (formData) => {
        fetch('http://localhost:8080/apartment/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if (response.ok) {
                    // 在庫情報が正常に追加された場合、フルーツデータを再取得して更新する
                    return fetchApartmentData();
                } else {
                    // エラーメッセージを表示するなどの処理を行う
                    console.error('Failed to add data');
                }
            })
            .catch(error => {
                console.error('Error adding data:', error);
            });
    }

    // 在庫情報を削除する関数
    const deleteData = (formData) => {
        fetch('http://localhost:8080/apartment/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if (response.ok) {
                    // 在庫情報が正常に追加された場合、フルーツデータを再取得して更新する
                    return fetchApartmentData();
                } else {
                    // エラーメッセージを表示するなどの処理を行う
                    console.error('Failed to delete data');
                }
            })
            .catch(error => {
                console.error('Error deleting data:', error);
            });
    }

    // フルーツデータを再取得する関数
    const fetchApartmentData = () => {
        fetch('http://localhost:8080/apartment')
            .then(response => response.json())
            .then(data => {
                setData(data);
            })
            .catch(error => {
                console.error('Error fetching fruit data:', error);
                setData([]);
            });
    }

    // フォームから送信された際の処理
    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);
        const newdata = {
            name: formData.get('name'),
            address: parseInt(formData.get('address')),
            sales: parseInt(formData.get('sales')),
            floorArea: parseInt(formData.get('floorArea'))
        };
        addData(newdata);
    }

    return (
        <div>
            <h3>物件情報</h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>物件コード</th>
                        <th>物件名</th>
                        <th>住所</th>
                        <th>担当者</th>
                        <th>床面積</th>
                        <th>削除</th>
                    </tr>
                </thead>
                <tbody>
                    {apartmentData}
                </tbody>
            </table>
            <h3>物件情報追加</h3>
            <form onSubmit={handleSubmit}>
                <label>
                    物件名:
                    <input type="text" name="name" required />
                </label>
                <label>
                    住所:
                    <input type="test" name="price" required />
                </label>
                <label>
                    担当者:
                    <input type="test" name="sales" />
                </label>
                <label>
                    床面積:
                    <input type="text" pattern="\d+(\.\d+)?" name="floorArea" />
                </label>
                <button type="submit">追加</button>
            </form>
        </div>
    );
}

export default Apartment;
