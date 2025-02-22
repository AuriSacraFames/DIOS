import { ApolloServer } from '@apollo/server';
import { startStandaloneServer } from '@apollo/server/standalone';
import { gql } from 'graphql-tag';
import { prisma } from './db.js';

// index.ts -> index.js
// db.ts -> db.js

( async function() {
    // .gql
    const typeDefs = gql`
        type Post {
            id: String
            title: String
            username: String
        }

        type Query {
            getAllPosts: [Post]
        }

        type Mutation {
            createPost(title: String, username: String): Post
        }
    `

    interface createPostInput {
        title: string
        username: string
    }

    const resolvers = {
        Mutation: {
            createPost: async (_parent : any, args : createPostInput) => {
                const post = await prisma.post.create({
                    data: {
                        title: args.title,
                        username: args.username
                    }
                });

                return post;
            }
        },
        Query: {
            getAllPosts : async () => {
                return await prisma.post.findMany(); // Easy way to get a list of posts -> [post1, ....]
            }
        },
        
    }

    // GraphQL Types vs Prisma Models
    // Post -> id, title, username
    // Prisma -> all the data being saved to your database
    
    const server = new ApolloServer({
        typeDefs,
        resolvers
    });

    const { url } = await startStandaloneServer(server, {
        listen: {port: 4000}
    });

    console.log("Server is ready at " + url); // localhost:4000
})();