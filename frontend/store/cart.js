// Cart
export const ADD_TO_CART = 'ADD_TO_CART';
export const REMOVE_FROM_CART = 'REMOVE_FROM_CART';
export const UPDATE_CART = 'UPDATE_CART';
export const DELETE_CART = 'DELETE_CART';

export function state() {
    return {
        data: []
    }
};

export const getters = {
    cartList: state => {
        return state.data;
    },
    totalPrice: state => {
        return state.data.reduce( ( acc, cur ) => {
            return acc + cur.price * cur.qty;
        }, 0 )
    },
    totalCount: state => {
        return state.data.reduce( ( acc, cur ) => {
            return acc + parseInt( cur.qty, 10 );
        }, 0 );
    }
}

export const actions = {
    addToCart: function ( { commit }, payload ) {
        commit( ADD_TO_CART, payload );

        this._vm.$notify( {
            group: 'addCartSuccess',
            text: `wurde Ihrer Merkliste hinzugefügt!`,
            data: payload.product
        } );
    },
    disaddFromCart: function ( { commit }, payload ) {
      commit( REMOVE_FROM_CART, payload );

      this._vm.$notify( {
        group: 'addCartSuccess',
        text: `wurde von Ihrer Merkliste entfernt`,
        data: payload.product
      } );
    },
    removeFromCart: function ( { commit }, payload ) {
        commit( REMOVE_FROM_CART, payload );
    },
    updateCart: function ( { commit }, payload ) {
        commit( UPDATE_CART, payload );
    },
    deleteCart: function ( { commit } ) {
      commit( DELETE_CART );
    }
}

export const mutations = {
    [ ADD_TO_CART ]( state, payload ) {
        let isAdded = state.data.findIndex( item => item.name === payload.product.name ) > -1;
        let qty = payload.product.qty ? payload.product.qty : 1;
        payload.product.qty = qty;

        if ( isAdded ) {
            state.data = state.data.reduce( ( acc, cur ) => {
                if ( cur.name === payload.product.name ) {
                    acc.push( {
                        ...cur,
                        qty: cur.qty + qty
                    } );
                } else {
                    acc.push( cur );
                }

                return acc;
            }, [] )
        } else {
            state.data.push( payload.product );
        }
    },
    [ REMOVE_FROM_CART ]( state, payload ) {
        let index = state.data.findIndex( item => item.name === payload.name );
        state.data.splice( index, 1 );
    },
    [ UPDATE_CART ]( state, payload ) {
        state.data = payload.cartItems;
    },
    [ DELETE_CART ]( state ) {
      state.data = [];
    }
}
