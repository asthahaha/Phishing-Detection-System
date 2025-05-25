from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    try:
        # Get the JSON payload from the request
        data = request.json
        text = data.get('text', 'No text provided')
        numeric_features = data.get('numeric_features', [])
        # Return the data as a response
        return jsonify({
            'received_text': text,
            'received_numeric_features': numeric_features
        })
    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    app.run(debug=True)
